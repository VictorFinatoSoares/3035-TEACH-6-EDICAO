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

interface League {
  name: string;
  seasonDisplay: string;
  standings: Standings[];
}

interface Season {
  year: number;
}

export function LeaguesStadings() {
  const [league, setLeague] = useState<League>();
  const [seasons, setSeasons] = useState<string[]>([]);
  const [selectedSeason, setSelectedSeason] = useState<string>("");
  const { isLoading, setLoadingState } = useLoading();

  const { leagueId } = useParams();

  const getLeagueStandings = async () => {
    setLoadingState(true);
    const response =
      leagueId &&
      (await getLeagueStandingsById(leagueId, parseInt(selectedSeason), "asc"));
    setLeague(response.data);
    setLoadingState(false);
  };

  const getSeasonsByLeague = async () => {
    setLoadingState(true);
    const response = leagueId && (await getLeagueSeasons(leagueId));
    setSeasons(response.data.seasons.map((item: Season) => String(item.year)));
    setLoadingState(false);
  };

  const handleChangeSelectedSeason = (
    event: React.ChangeEvent<HTMLSelectElement>,
  ) => {
    event.preventDefault();
    setSelectedSeason(event.target.value);
  };
  useEffect(() => {
    if (selectedSeason?.length) getLeagueStandings();
  }, [selectedSeason]);

  useEffect(() => {
    if (!selectedSeason?.length) setSelectedSeason(seasons[0]);
  }, [seasons, selectedSeason]);

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
