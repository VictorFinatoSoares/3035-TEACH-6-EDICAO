/**
 * Camada de serviços relacionada às ligas de futebol.
 * Centraliza os caminhos da API usados pelas páginas e componentes.
 */
import { API } from "./api";

// Obtém a relação de todas as ligas disponibilizadas pela API.
export async function getLeagues() {
  try {
    const response = await API.get("/leagues");
    return response.data;
  } catch (err) {
    throw new Error(err as string);
  }
}

// Obtém a classificação de uma liga para uma temporada e ordenação específicas.
export async function getLeagueStandingsById(
  leagueId: string,
  season: number,
  sort: string,
) {
  try {
    const response = await API.get(
      `/leagues/${leagueId}/standings?season=${season}&sort=${sort}`,
    );

    return response.data;
  } catch (err) {
    throw new Error(err as string);
  }
}

// Obtém as temporadas que podem ser consultadas para uma determinada liga.
export async function getLeagueSeasons(leagueId: string) {
  try {
    const response = await API.get(`/leagues/${leagueId}/seasons`);
    return response.data;
  } catch (err) {
    throw new Error(err as string);
  }
}
