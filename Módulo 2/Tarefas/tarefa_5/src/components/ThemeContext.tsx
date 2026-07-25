import { useState, createContext, ReactNode } from "react";

interface ThemeContextType {
  currentTheme: string;
  changeTheme: () => void;
}

export const ThemeContext = createContext<ThemeContextType | undefined>(
  undefined,
);

export function ThemeProvider({ children }: { children: ReactNode }) {
  const [currentTheme, setCurrentTheme] = useState("light");

  function changeTheme() {
    const newTheme = currentTheme == "dark" ? "light" : "dark";
    setCurrentTheme(newTheme);
  }

  return (
    <ThemeContext.Provider value={{ currentTheme, changeTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}
