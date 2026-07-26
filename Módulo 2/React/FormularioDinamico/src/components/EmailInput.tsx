import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";

export function EmailInput() {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();
  return (
    <div className="mb-4">
      <label htmlFor="email">E-mail</label>
      <input className="" type="email" id="email" {...register("email")} />
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="email" />
      </p>
    </div>
  );
}
