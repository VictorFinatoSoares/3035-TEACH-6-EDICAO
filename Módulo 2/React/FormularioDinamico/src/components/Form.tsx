import { useState } from "react";
import { EyeIcon, EyeOffIcon, Loader } from "lucide-react";
import { useHookFormMask } from "use-mask-input"; // hook que integra máscaras (telefone, CPF, CEP) com o react-hook-form
import { FieldValues, useForm } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message"; // componente para exibir mensagens de erro de um campo específico
import { zodResolver } from "@hookform/resolvers/zod"; // conecta o schema do zod como validador do react-hook-form
import { UserRegisterData, userRegisterSchema } from "./Schema"; // tipo dos dados do formulário e o schema de validação (zod)
import toast from "react-hot-toast";

export default function Form() {
  // Controla se a senha está visível (texto) ou oculta (password)
  const [isPasswordVisible, setPasswordVisible] = useState(false);

  const {
    handleSubmit, // wrapper que valida os dados antes de chamar a função de submit
    register, // função usada para "registrar" cada input no react-hook-form
    setValue, // permite definir o valor de um campo programaticamente (usado no autocomplete do CEP)
    setError, // permite setar erros manualmente em um campo (usado para erros vindos da API)
    reset, // Permite limpar o formulário quando houver sucesso
    formState: { isSubmitting, errors }, // isSubmitting: true enquanto o submit está em andamento; errors: objeto com erros de validação
  } = useForm<UserRegisterData>({ resolver: zodResolver(userRegisterSchema) }); // usa o schema do zod para validar os dados do formulário

  // Versão do "register" que já suporta aplicar máscaras de input (ex: telefone, CPF, CEP)
  const registerWithMask = useHookFormMask(register);

  /**
   * Disparado quando o campo de CEP perde o foco (onBlur).
   * Faz uma requisição à BrasilAPI para buscar o endereço a partir do CEP
   * e preenche automaticamente os campos "address" (endereço) e "city" (cidade).
   */
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

  /**
   * Função chamada ao submeter o formulário, somente após passar pela validação do zod.
   * Envia os dados para a API de cadastro de usuário e trata erros retornados pelo backend.
   */
  async function onsubmit(data: FieldValues) {
    // Envia os dados do formulário via POST para a API de registro
    const res = await fetch(
      "https://apis.codante.io/api/register-user/register",
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
      },
    );

    const resData = await res.json(); // corpo da resposta da API (pode conter erros ou dados de sucesso)

    if (!res.ok) {
      // Se a API retornou erro (status não-2xx), percorre os erros por campo
      // e os associa manualmente aos respectivos campos do formulário
      for (const field in resData.errors) {
        setError(field as keyof UserRegisterData, {
          type: "manual", // indica que o erro foi definido manualmente (não pela validação do zod)
          message: resData.errors[field], // mensagem de erro específica retornada pela API para esse campo
        });
        toast.error("Erro ao  cadastrar usuário"); // Usa o toast pra mandar um aviso de erro
      }
    } else {
      // Cadastro realizado com sucesso: apenas loga a resposta no console
      // (não há redirecionamento ou feedback visual de sucesso implementado)
      toast.success("Cadastrado realizado com sucesso!"); // Usa o toast pra mandar um aviso de suceesso
      reset();
    }
  }

  return (
    // handleSubmit valida os dados com o zod antes de chamar "onsubmit"
    <form onSubmit={handleSubmit(onsubmit)}>
      {/* Campo: Nome completo */}
      <div className="mb-4">
        <label htmlFor="name">Nome Completo</label>
        <input type="text" id="name" {...register("name")} />

        {/* Exibe mensagem de erro de validação referente ao campo "name", se houver */}
        <p className="text-xs text-red-400 mt-1">
          <ErrorMessage errors={errors} name="name" />
        </p>
      </div>

      {/* Campo: E-mail */}
      <div className="mb-4">
        <label htmlFor="email">E-mail</label>
        <input className="" type="email" id="email" {...register("email")} />
        <p className="text-xs text-red-400 mt-1">
          <ErrorMessage errors={errors} name="email" />
        </p>
      </div>

      {/* Campo: Senha (com botão de mostrar/ocultar) */}
      <div className="mb-4">
        <label htmlFor="password">Senha</label>
        <div className="relative">
          <input
            // Alterna o tipo do input entre "text" (visível) e "password" (oculto)
            // com base no estado "isPasswordVisible"
            type={isPasswordVisible ? "text" : "password"}
            id="password"
            {...register("password")}
          />
          <p className="text-xs text-red-400 mt-1">
            <ErrorMessage errors={errors} name="password" />
          </p>
          <span className="absolute right-3 top-3">
            {/* Botão que alterna a visibilidade da senha ao ser clicado */}
            <button
              type="button" // evita que o botão dispare o submit do formulário
              onClick={() => setPasswordVisible(!isPasswordVisible)}
            >
              {isPasswordVisible ? (
                // Ícone de "olho aberto": indica que a senha está visível
                <EyeIcon size={20} className="text-slate-600 cursor-pointer" />
              ) : (
                // Ícone de "olho fechado": indica que a senha está oculta
                <EyeOffIcon
                  size={20}
                  className="text-slate-600 cursor-pointer"
                />
              )}
            </button>
          </span>
        </div>
      </div>

      {/* Campo: Confirmar senha (usa a mesma visibilidade do campo de senha) */}
      <div className="mb-4">
        <label htmlFor="confirm-password">Confirmar Senha</label>
        <div className="relative">
          <input
            type={isPasswordVisible ? "text" : "password"}
            id="confirm-password"
            {...register("password_confirmation")}
          />
          <p className="text-xs text-red-400 mt-1">
            <ErrorMessage errors={errors} name="password_confirmation" />
          </p>
        </div>
      </div>

      {/* Campo: Telefone celular, com máscara (99) 99999-9999 */}
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

      {/* Campo: CPF, com máscara 999.999.999-99 */}
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

      {/* Campo: CEP, com máscara 99999-999 e busca automática de endereço no onBlur */}
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

      {/* Campo: Endereço — preenchido automaticamente a partir do CEP e desabilitado para edição manual */}
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

      {/* Campo: Cidade — preenchido automaticamente a partir do CEP e desabilitado para edição manual */}
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

      {/* terms and conditions input */}
      {/* Checkbox de aceite dos termos e condições, obrigatório para o envio (validado pelo schema) */}
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

      {/* Botão de submit: fica desabilitado e mostra um spinner enquanto o formulário está sendo enviado */}
      <button
        disabled={isSubmitting}
        type="submit"
        className="flex items-center justify-center bg-slate-500 font-semibold text-white w-full rounded-xl p-4 mt-10 hover:bg-slate-600 transition-colors"
      >
        {isSubmitting ? <Loader className="animate-spin" /> : "Cadastrar"}
      </button>
    </form>
  );
}
