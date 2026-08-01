/**
 * Página de classificação de uma liga.
 * Usa o identificador presente na URL para buscar temporadas e a tabela correspondente.
 */
import { useParams } from "react-router-dom";

import {
  getLeagueStandingsById,
  getLeagueSeasons,
} from "../services/leagues.service";

import { Header } from "../components/Header";
import { Table, type Standings } from "../components/Table";
import { useState, useEffect } from "react";
import { Select } from "../components/Select";

import { useLoading } from "../Context/LoadingContext";
import { Spinner } from "../components/Spinner";

// Dados gerais da liga e sua classificação na temporada selecionada.
interface League {
  name: string;
  seasonDisplay: string;
  standings: Standings[];
}

// Formato de cada temporada retornada pela API antes da conversão para texto.
interface Season {
  year: number;
}

export function LeaguesStadings() {
  // Armazena a classificação atualmente exibida.
  const [league, setLeague] = useState<League>();
  // Mantém as temporadas disponíveis e a opção escolhida pelo usuário.
  const [seasons, setSeasons] = useState<string[]>([]);
  const [selectedSeason, setSelectedSeason] = useState<string>("");
  // Compartilha o controle do indicador visual de carregamento.
  const { isLoading, setLoadingState } = useLoading();

  // Captura da URL o identificador dinâmico definido na rota /standings/:leagueId.
  const { leagueId } = useParams();

  // Busca a classificação conforme a liga e a temporada selecionadas.
  const getLeagueStandings = async () => {
    setLoadingState(true);
    const response =
      leagueId &&
      (await getLeagueStandingsById(leagueId, parseInt(selectedSeason), "asc"));
    setLeague(response.data);
    setLoadingState(false);
  };

  // Busca as temporadas disponíveis para preencher o componente Select.
  const getSeasonsByLeague = async () => {
    setLoadingState(true);
    const response = leagueId && (await getLeagueSeasons(leagueId));
    setSeasons(response.data.seasons.map((item: Season) => String(item.year)));
    setLoadingState(false);
  };

  // Atualiza a temporada quando o usuário escolhe uma nova opção.
  const handleChangeSelectedSeason = (
    event: React.ChangeEvent<HTMLSelectElement>,
  ) => {
    event.preventDefault();
    setSelectedSeason(event.target.value);
  };
  // Atualiza a tabela sempre que uma temporada válida é selecionada.
  useEffect(() => {
    if (selectedSeason?.length) getLeagueStandings();
  }, [selectedSeason]);

  // Define a primeira temporada recebida como seleção inicial.
  useEffect(() => {
    if (!selectedSeason?.length) setSelectedSeason(seasons[0]);
  }, [seasons, selectedSeason]);

  // Recarrega a lista de temporadas quando o identificador da liga muda.
  useEffect(() => {
    getSeasonsByLeague();
  }, [leagueId]);

  return (
    <main className="max-sm:px-4 py-14 px-40">
      <Header />
      <a className="cursor-pointer hover:underline" href="/">
        ⬅️ Back
      </a>
      <section className="w-full mt-3">
        <div className="flex justify-between font-light text-xl">
          <h3>
            {league?.name} - {league?.seasonDisplay}
          </h3>
          <Select options={seasons} onChange={handleChangeSelectedSeason} />
        </div>
        <hr className="mt-4" />
        {/* Exibe o Spinner durante as consultas e a tabela após o carregamento. */}
        {isLoading ? (
          <div className="my-10 flex justify-center items-center">
            <Spinner />
          </div>
        ) : (
          league && <Table standings={league?.standings} />
        )}
      </section>
    </main>
  );
}
