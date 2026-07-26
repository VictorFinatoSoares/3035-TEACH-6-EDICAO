import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";

export function TermsInput() {
  const {
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();
  return (
    <div className="mb-4">
      <input
        type="checkbox"
        id="terms"
        className="mr-2 accent-slate-500"
        {...register("terms")}
      />
      <label
        className="text-sm  font-light text-slate-500 mb-1 inline"
        htmlFor="terms"
      >
        Aceito os{" "}
        <span className="underline hover:text-slate-900 cursor-pointer">
          termos e condições
        </span>
      </label>
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="terms" />
      </p>
    </div>
  );
}
