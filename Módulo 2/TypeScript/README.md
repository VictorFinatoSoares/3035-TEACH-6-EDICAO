# Estudos de TypeScript

Esta pasta reúne exercícios isolados de tipagem e configuração do compilador TypeScript. O objetivo é entender como declarar contratos para dados, funções e objetos antes de aplicar esses conceitos em interfaces React.

## Conteúdo estudado

- tipos primitivos como `string` e `number`;
- criação de aliases com `type`;
- tipagem de parâmetros e retorno de funções;
- desestruturação de objetos tipados;
- composição de tipos, como `User` contendo um `Address`;
- propriedades opcionais com `?`;
- criação de interfaces;
- extensão de um tipo por uma interface com `extends`;
- verificação de objetos em tempo de compilação.

## Exercícios presentes

O arquivo `src/index.ts` contém dois exemplos:

1. um cálculo de imposto com objeto de parâmetros e retorno numérico, mantido comentado como referência;
2. modelos `Address`, `User` e `Admin`, incluindo endereço opcional e uma instância de administrador.

## Estrutura

- `src/index.ts`: código-fonte dos estudos;
- `tsconfig.json`: regras do compilador;
- `dist/`: JavaScript, declarações e source maps gerados pela compilação.

## Configuração relevante

O compilador lê `src/` e envia a saída para `dist/`. A configuração usa modo estrito, não emite arquivos quando há erros e gera `.js`, `.d.ts` e mapas correspondentes. Também estão habilitadas verificações mais rigorosas para índices e propriedades opcionais.

## Como compilar e executar

Com o TypeScript disponível no ambiente:

```bash
npx tsc
node dist/index.js
```

O exemplo ativo apenas declara o objeto `userAdmin`, portanto não produz saída no terminal. O principal resultado do exercício é a validação estática e a geração dos arquivos compilados.
