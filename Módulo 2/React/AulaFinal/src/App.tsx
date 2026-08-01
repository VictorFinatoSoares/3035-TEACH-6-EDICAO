/**
 * Componente raiz da aplicação.
 * Reúne os providers globais e define qual página será exibida para cada URL.
 */
import { BrowserRouter, Routes, Route } from "react-router-dom";

import { LoadingContextProvider } from "./Context/LoadingContext";

import { Content } from "./pages/Content";
import { LeaguesStadings } from "./pages/LeaguesStandings";

function App() {
  return (
    // Disponibiliza o estado global de carregamento para todas as rotas.
    <LoadingContextProvider>
      {/* Ativa a navegação por URL no navegador sem recarregar a aplicação inteira. */}
      <BrowserRouter>
        <Routes>
          {/* Página inicial com a lista de ligas. */}
          <Route path="/" element={<Content />} />
          {/* Página de classificação; leagueId identifica a liga selecionada. */}
          <Route path="/standings/:leagueId" element={<LeaguesStadings />} />
        </Routes>
      </BrowserRouter>
    </LoadingContextProvider>
  );
}

export default App;
