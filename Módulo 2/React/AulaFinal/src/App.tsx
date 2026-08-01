import { BrowserRouter, Routes, Route } from "react-router-dom";

import { LoadingContextProvider } from "./Context/LoadingContext";

import { Content } from "./pages/Content";
import { LeaguesStadings } from "./pages/LeaguesStandings";

function App() {
  return (
    <LoadingContextProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Content />} />
          <Route path="/standings/:leagueId" element={<LeaguesStadings />} />
        </Routes>
      </BrowserRouter>
    </LoadingContextProvider>
  );
}

export default App;
