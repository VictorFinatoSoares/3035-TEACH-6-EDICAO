import { useFormContext } from "react-hook-form"; // Serve para usar o contexto do formulário
import { UserRegisterData } from "./Schema"; // Pega a metodologia (ou esquema) de como é organizado o registro de dados do usuário

export function AddressInput() {
  const { register } = useFormContext<UserRegisterData>(); // Referencia register vindo do contexto
  return (
    //
    <div className="mb-4">
      <label htmlFor="address">Endereço</label>
      <input
        className="disabled:bg-slate-200"
        type="text"
        id="address"
        disabled
        {...register("address")}
      />
    </div>
  );
}
