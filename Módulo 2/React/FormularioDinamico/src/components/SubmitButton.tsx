import { Loader } from "lucide-react";
import { useFormContext } from "react-hook-form";
import { UserRegisterData } from "./Schema";

export function SubmitButton() {
  const {
    formState: { isSubmitting },
  } = useFormContext<UserRegisterData>();
  return (
    <button
      disabled={isSubmitting}
      type="submit"
      className="flex items-center justify-center bg-slate-500 font-semibold text-white w-full rounded-xl p-4 mt-10 hover:bg-slate-600 transition-colors"
    >
      {isSubmitting ? <Loader className="animate-spin" /> : "Cadastrar"}
    </button>
  );
}
