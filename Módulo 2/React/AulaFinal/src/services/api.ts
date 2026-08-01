import axios from "axios";

export const API = axios.create({
  baseURL: "https://football-standings-api.vercel.app",
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});
