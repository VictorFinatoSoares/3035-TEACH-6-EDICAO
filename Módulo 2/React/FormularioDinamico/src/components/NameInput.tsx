import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";

export function NameInput() {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();
  return (
    <div className="mb-4">
      <label htmlFor="name">Nome Completo</label>
      <input type="text" id="name" {...register("name")} />

      {/* Exibe mensagem de erro de validação referente ao campo "name", se houver */}
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="name" />
      </p>
    </div>
  );
}
