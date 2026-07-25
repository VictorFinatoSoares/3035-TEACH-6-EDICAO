import { useContext } from "react";
import { ThemeContext } from "./ThemeContext";

export function ChangeThemeButton() {
  const context = useContext(ThemeContext);
  if (!context) throw new Error("O botão não conseguiu acessar o contexto!");

  const { changeTheme } = context;

  return (
    <button
      onClick={() => changeTheme()}
      className="dark:bg-gray-800 bg-gray-200 dark:text-gray-300 text-gray-900 p-4 rounded-full size
        font-semibold size-96 text-4xl scale-100 hover:scale-95 hover:shadow-md hover:shadow-blue-400
        dark:hover:shadow-red-400 duration-1000"
    >
      Alterar Tema
    </button>
  );
}
