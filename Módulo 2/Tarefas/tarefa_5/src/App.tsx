import React from "react";
import { ThemeProvider } from "./components/ThemeContext";
import { Home } from "./components/Home";

function App() {
  return (
    <ThemeProvider>
      <Home />
    </ThemeProvider>
  );
}

export default App;
