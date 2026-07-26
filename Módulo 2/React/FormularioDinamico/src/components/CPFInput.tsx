import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";
import { useHookFormMask } from "use-mask-input";

export function CPFInput() {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();

  const registerWithMask = useHookFormMask(register);

  return (
    <div className="mb-4">
      <label htmlFor="cpf">CPF</label>
      <input
        type="text"
        id="cpf"
        {...registerWithMask("cpf", "999.999.999-99")}
      />
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="cpf" />
      </p>
    </div>
  );
}
