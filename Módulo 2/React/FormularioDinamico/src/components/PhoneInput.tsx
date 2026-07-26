import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";
import { useHookFormMask } from "use-mask-input";

export function PhoneInput() {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();

  const registerWithMask = useHookFormMask(register);

  return (
    <div className="mb-4">
      <label htmlFor="phone">Telefone Celular</label>
      <input
        type="text"
        id="phone"
        {...registerWithMask("phone", "(99) 99999-9999")}
      />
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="phone" />
      </p>
    </div>
  );
}
