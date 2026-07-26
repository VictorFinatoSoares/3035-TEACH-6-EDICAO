import { z } from "zod";

// Schema de validação do formulário de cadastro de usuário, usando o zod.
// Cada campo do objeto define as regras de validação e as mensagens de erro
// que serão exibidas quando o valor informado não atender aos critérios.
export const userRegisterSchema = z
  .object({
    // Nome completo do usuário
    name: z
      .string("Informe seu nome") // mensagem exibida quando o valor não é uma string (ex: undefined/null)
      .min(2, "O nome precisa ter no mínimo 2 caracteres") // exige pelo menos 2 caracteres
      .max(255, "O nome precisa ter no máximo 255 caracteres"), // limita a 255 caracteres

    // E-mail do usuário
    email: z
      .string("Informe seu e-mail") // mensagem exibida quando o valor não é uma string
      .min(1, "Informe seu e-mail") // garante que o campo não esteja vazio
      .email("E-mail inválido"), // valida o formato de e-mail

    // Senha de acesso
    password: z
      .string("Informe sua senha") // mensagem exibida quando o valor não é uma string
      .min(8, "A senha deve ter no mínimo 8 caracteres"), // exige no mínimo 8 caracteres

    // Confirmação da senha (validada posteriormente contra "password" no .refine)
    password_confirmation: z
      .string("Confirme sua senha") // mensagem exibida quando o valor não é uma string
      .min(8, "A senha deve ter no mínimo 8 caracteres"), // exige no mínimo 8 caracteres

    // Telefone celular
    phone: z
      .string()
      .min(1, "Informe seu celular") // garante que o campo não esteja vazio
      .regex(/^\(\d{2}\) \d{5}-\d{4}$/, "Telefone inválido"), // exige o formato (99) 99999-9999

    // CPF do usuário
    cpf: z
      .string()
      .min(1, "Informe seu CPF") // garante que o campo não esteja vazio
      .regex(/^\d{3}\.\d{3}\.\d{3}-\d{2}$/, "CPF inválido"), // exige o formato 999.999.999-99

    // CEP (usado para autocompletar endereço e cidade via API)
    zipcode: z
      .string()
      .min(1, "Informe seu CEP") // garante que o campo não esteja vazio
      .regex(/^\d{5}-?\d{3}$/, "CEP inválido"), // aceita o formato 99999-999 ou 99999999 (hífen opcional)

    // Endereço (preenchido automaticamente a partir do CEP, mas ainda validado)
    address: z.string().min(1, "Informe seu endereço"),

    // Cidade (preenchida automaticamente a partir do CEP, mas ainda validada)
    city: z.string().min(1, "Informe sua cidade"),

    // Aceite dos termos e condições: precisa ser exatamente "true" (checkbox marcado)
    terms: z.literal(true, {
      message: "Você precisa concordar com os termos e condições",
    }),
  })
  // Validação adicional após checar todos os campos individualmente:
  // garante que "password" e "password_confirmation" sejam iguais.
  .refine((data) => data.password === data.password_confirmation, {
    message: "As senhas devem coincidir",
    path: ["password_confirmation"], // associa o erro ao campo "password_confirmation" (onde será exibido)
  });

// Tipo TypeScript inferido automaticamente a partir do schema acima,
// usado para tipar os dados do formulário (ex: no useForm<UserRegisterData>)
export type UserRegisterData = z.infer<typeof userRegisterSchema>;
