import { useFormContext } from "react-hook-form";
import { UserRegisterData } from "./Schema";

export function CityInput() {
  const { register } = useFormContext<UserRegisterData>();

  return (
    <div className="mb-4">
      <label htmlFor="city">Cidade</label>
      <input
        className="disabled:bg-slate-200"
        type="text"
        id="city"
        disabled
        {...register("city")}
      />
    </div>
  );
}
