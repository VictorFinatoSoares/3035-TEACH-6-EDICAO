import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";
import { EyeIcon, EyeOffIcon } from "lucide-react";

type Props = {
  visibility: boolean;
  onToggleVisibility: () => void;
};

export function PasswordInput({ visibility, onToggleVisibility }: Props) {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();

  return (
    <div className="mb-4">
      <label htmlFor="password">Senha</label>
      <div className="relative">
        <input
          // Alterna o tipo do input entre "text" (visível) e "password" (oculto)
          // com base no estado "isPasswordVisible"
          type={visibility ? "text" : "password"}
          id="password"
          {...register("password")}
        />
        <p className="text-xs text-red-400 mt-1">
          <ErrorMessage errors={errors} name="password" />
        </p>
        <span className="absolute right-3 top-3">
          {/* Botão que alterna a visibilidade da senha ao ser clicado */}
          <button
            type="button" // evita que o botão dispare o submit do formulário
            onClick={() => onToggleVisibility()}
          >
            {visibility ? (
              // Ícone de "olho aberto": indica que a senha está visível
              <EyeIcon size={20} className="text-slate-600 cursor-pointer" />
            ) : (
              // Ícone de "olho fechado": indica que a senha está oculta
              <EyeOffIcon size={20} className="text-slate-600 cursor-pointer" />
            )}
          </button>
        </span>
      </div>
    </div>
  );
}
