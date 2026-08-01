/**
 * Página inicial da aplicação.
 * Busca as ligas na API e apresenta cada uma por meio do componente Card.
 */
import { useEffect, useState } from "react";

import { useLoading } from "../Context/LoadingContext";

import { getLeagues } from "../services/leagues.service";

import { Card } from "../components/Card";
import { Header } from "../components/Header";
import { Spinner } from "../components/Spinner";

// Estrutura dos dados de liga utilizados para montar os cards.
interface League {
  id: string;
  name: string;
  logos: {
    light: string;
    dark: string;
  };
}

export function Content() {
  // Mantém em memória a lista de ligas retornada pela API.
  const [leagues, setLeagues] = useState<League[]>([]);

  // Obtém do contexto o estado compartilhado que controla o carregamento.
  const { isLoading, setLoadingState } = useLoading();

  // Executa a requisição e salva a lista recebida no estado local.
  const getLeaguesList = async () => {
    setLoadingState(true);
    const response = await getLeagues();
    setLeagues(response.data);
    setLoadingState(false);
  };

  // Solicita as ligas quando a página é montada pela primeira vez.
  useEffect(() => {
    getLeaguesList();
  }, []);

  return (
    <main className="max-sm:px-4 py-14  px-48">
      <Header />
      <section className="w-full">
        <h3 className="font-light text-xl">Leagues</h3>
        <hr className="my-4" />

        {/* Alterna entre o indicador de carregamento e a grade de ligas. */}
        {isLoading ? (
          <div className="my-10 flex justify-center items-center">
            <Spinner />
          </div>
        ) : (
          <div className="grid max-sm:grid-cols-3 grid-cols-5 gap-4">
            {/* Transforma cada liga recebida em um card navegável. */}
            {leagues.map(({ id, name, logos }) => (
              <Card key={id} id={id} title={name} imageSrc={logos.light} />
            ))}
          </div>
        )}
      </section>
    </main>
  );
}
