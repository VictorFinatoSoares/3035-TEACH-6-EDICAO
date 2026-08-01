/**
 * Configuração central do cliente HTTP da aplicação.
 * Todas as funções de serviço reutilizam esta instância do Axios.
 */
import axios from "axios";

// Define a URL base e os cabeçalhos comuns enviados para a API de futebol.
export const API = axios.create({
  baseURL: "https://football-standings-api.vercel.app",
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});
