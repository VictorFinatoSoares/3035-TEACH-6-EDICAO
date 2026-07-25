import { useContext } from "react";
import { ThemeContext } from "./ThemeContext";
import { ChangeThemeButton } from "./ChangeThemeButton";

export function Home() {
  const context = useContext(ThemeContext);
  if (!context) throw new Error("Não foi possível acessar o contexto!");

  const { currentTheme } = context;

  return (
    <div className={currentTheme === "dark" ? "dark" : ""}>
      <div className="dark:bg-gray-900 bg-gray-300  w-screen h-screen flex justify-center items-center duration-1000">
        <ChangeThemeButton />
      </div>
    </div>
  );
}
