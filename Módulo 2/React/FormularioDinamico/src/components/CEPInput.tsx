import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";
import { UserRegisterData } from "./Schema";
import { useHookFormMask } from "use-mask-input";

export function CEPInput() {
  const {
    setValue,
    register,
    formState: { errors },
  } = useFormContext<UserRegisterData>();

  const registerWithMask = useHookFormMask(register);

  async function handleZipCodeBlur(e: React.FocusEvent<HTMLInputElement>) {
    const zipcode = e.target.value; // valor atual digitado no campo de CEP

    // Consulta a API pública BrasilAPI (v2) para obter os dados do endereço pelo CEP
    const res = await fetch(`https://brasilapi.com.br/api/cep/v2/${zipcode}`);

    if (res.ok) {
      // Se a requisição foi bem-sucedida, extrai os dados e preenche os campos do formulário
      const data = await res.json();
      setValue("address", data.street); // preenche o campo "address" com o logradouro retornado
      setValue("city", data.city); // preenche o campo "city" com a cidade retornada
    }
    // Caso a requisição falhe (CEP inválido, erro de rede, etc.), nada é feito aqui
    // (não há tratamento de erro explícito para esse caso)
  }

  return (
    <div className="mb-4">
      <label htmlFor="cep">CEP</label>
      <input
        type="text"
        id="cep"
        {...registerWithMask("zipcode", "99999-999", {
          onBlur: handleZipCodeBlur, // dispara a busca do endereço na BrasilAPI quando o campo perde o foco
        })}
      />
      <p className="text-xs text-red-400 mt-1">
        <ErrorMessage errors={errors} name="zipcode" />
      </p>
    </div>
  );
}
