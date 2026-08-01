# Tarefa 5 — Alternância de tema com Context API

Aplicação React que alterna toda a interface entre os temas claro e escuro. O tema atual e a função de troca são compartilhados por Context API, sem necessidade de repassar propriedades manualmente entre componentes.

## Funcionalidades

- iniciar a página no tema claro;
- alternar entre os temas claro e escuro;
- atualizar fundo, texto e efeitos do botão;
- aplicar uma transição visual entre os estados.

## Conceitos praticados

- estado com `useState`;
- contexto tipado com `createContext`;
- Provider para compartilhar estado e comportamento;
- consumo do contexto com `useContext`;
- tipagem de `children` com `ReactNode`;
- classes condicionais;
- modo escuro, estados de interação e transições com Tailwind CSS.

## Organização dos componentes

- `App.tsx`: conecta `ThemeProvider` e `Home`;
- `ThemeContext.tsx`: declara o contrato do contexto, mantém `currentTheme` e fornece `changeTheme`;
- `Home.tsx`: lê o tema e aplica a classe que ativa o modo escuro;
- `ChangeThemeButton.tsx`: consome a função de alternância e renderiza o botão;
- `index.css`: inicializa as camadas do Tailwind CSS.

## Como executar

```bash
npm install
npm start
```

Para gerar a versão de produção, execute `npm run build`.

## Tecnologias

React, TypeScript 4.9.5, Context API, Tailwind CSS 3 e Create React App.
