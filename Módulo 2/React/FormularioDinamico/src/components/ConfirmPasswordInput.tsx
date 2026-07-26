import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";

type Props = {
  visibility: boolean;
};

export function ConfirmPasswordInput({ visibility }: Props) {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();
  return (
    <div className="mb-4">
      <label htmlFor="confirm-password">Confirmar Senha</label>
      <div className="relative">
        <input
          type={visibility ? "text" : "password"}
          id="confirm-password"
          {...register("password_confirmation")}
        />
        <p className="text-xs text-red-400 mt-1">
          <ErrorMessage errors={errors} name="password_confirmation" />
        </p>
      </div>
    </div>
  );
}
