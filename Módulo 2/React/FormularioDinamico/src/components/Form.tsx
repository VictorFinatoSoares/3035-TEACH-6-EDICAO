import { useForm, FormProvider } from "react-hook-form"; // Useform é o que é usado pra criar o formulário, com a possibilidade de registros etc, formprovider é o que transmitirá os métodos do formulário para os componentes filho de Form.tsx
import { zodResolver } from "@hookform/resolvers/zod"; // zodResolver é o tradutor que traduz as regras do zod (schema) para o RHF entender na hora do registro
import { UserRegisterData, userRegisterSchema } from "./Schema"; // registerdata é a forma que os campos terão, name:string, email:string etc, só pra definir quais campos serão e seus tipos
import toast from "react-hot-toast"; // Biblioteca usada para notificar erros/acertos depois da chamada da api (o toaster está no app.tsx)
import { useState } from "react"; // Usado pra criar o estado de visibilidade da senha e alterá-lo no componente senha

// Respectivos componentes do form
import { NameInput } from "./NameInput";
import { EmailInput } from "./EmailInput";
import { PasswordInput } from "./PasswordInput";
import { ConfirmPasswordInput } from "./ConfirmPasswordInput";
import { PhoneInput } from "./PhoneInput";
import { CPFInput } from "./CPFInput";
import { CEPInput } from "./CEPInput";
import { AddressInput } from "./AddressInput";
import { CityInput } from "./CityInput";
import { TermsInput } from "./TermsInput";
import { SubmitButton } from "./SubmitButton";

// Função que renderiza o formulário por completo
export default function Form() {
  // Controla se a senha está visível (texto) ou oculta (password)
  const [isPasswordVisible, setPasswordVisible] = useState(false);

  // Pega TODOS os métodos que o useform retorna, informa ao TS que o tipo dele vão ser o UserRegisterData (os campos como nome: string etc), e passa como regra de validação (resolver) o schema do zod.
  const methods = useForm<UserRegisterData>({
    resolver: zodResolver(userRegisterSchema),
  });

  // Referencia métodos que vem do useForm (guardado no methods), logo, em vez de usar TUDO que vem dele, aqui referenciamos o que usamos vindo do methods
  const {
    handleSubmit, // Recebe minha função onsubmit e devolve uma nova função: essa nova função, quando o form é enviado, valida os dados primeiro e só chama onsubmit(data) se passar na validação
    setError, // Função para definir erros manualmente
    reset, // Permite limpar o formulário quando houver sucesso
  } = methods; // Pega essas funções do methods

  /**
   * Função chamada ao submeter o formulário, somente após passar pela validação do zod.
   * Envia os dados para a API de cadastro de usuário e trata erros retornados pelo backend.
   */
  async function onsubmit(data: UserRegisterData) {
    // Envia os dados do formulário via POST para a API de registro
    const res = await fetch(
      "https://apis.codante.io/api/register-user/register",
      {
        method: "POST",
        headers: { "Content-Type": "application/json" }, // Diz ao browser como o envio deve ser interpretado (no caso, um json)
        body: JSON.stringify(data), // Transforma o json em string, pois o browser só consegue passar texto puro, quando chegar a API, será trabalhado como json por conta dos headers
      },
    );

    const resData = await res.json(); // Guarda a resposta da API (vinda em string) e transforma em json.

    // Se a API deu retorna erro
    if (!res.ok) {
      // Percorre cada campo em que a API apontou um erro
      for (const field in resData.errors) {
        setError(field as keyof UserRegisterData, {
          // Define manualmente um erro no campo descrito da API como chave do UserRegisterData (os nomes vão ter que ser iguais para associar)
          type: "manual", // Indica erro manual (nada de validação do ZOD)
          message: resData.errors[field], // Mensagem de erro específica retornada pela API para esse campo
        });
        toast.error("Erro ao  cadastrar usuário"); // Usa o toast pra mandar um aviso de erro
      }
    } else {
      // Se houve um sucesso
      // Não há redirecionamento nem autenticação
      toast.success("Cadastrado realizado com sucesso!"); // Usa o toast pra mandar um aviso de suceesso
      reset(); // Limpa formulário
    }
  }

  return (
    // Passa tudo com FormProvider, usando spread nos métodos pra extrair cada método e transmitir para os componentes filhos usarem
    <FormProvider {...methods}>
      <form onSubmit={handleSubmit(onsubmit)}>
        {/*Renderiza todos os componentes*/}
        <NameInput />
        <EmailInput />
        {/* O PasswordInput recebe o estado atual de visibilidade (visibility)
    e uma função onToggleVisibility, que quando chamada, inverte esse estado lá no Form.tsx */}
        <PasswordInput
          visibility={isPasswordVisible}
          onToggleVisibility={() => setPasswordVisible((prev) => !prev)}
        />
        <ConfirmPasswordInput visibility={isPasswordVisible} />
        <PhoneInput />
        <CPFInput />
        <CEPInput />
        <AddressInput />
        <CityInput />
        <TermsInput />
        <SubmitButton />
      </form>
    </FormProvider>
  );
}
