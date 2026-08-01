# Tarefa 1 — Contador com React

Primeiro exercício de estado no React. A interface exibe um contador iniciado em zero e um botão que acrescenta uma unidade a cada clique.

## O que é praticado

- criação de um componente funcional;
- escrita de interface com JSX/TSX;
- estado local com o hook `useState`;
- atualização baseada no valor anterior do estado;
- tratamento de clique com `onClick`;
- renderização automática após a alteração do estado;
- estilização separada em CSS.

## Estrutura principal

- `src/App.tsx`: mantém o estado `count`, define a função `add` e renderiza a interface;
- `src/App.css`: estiliza o contador e o botão;
- `src/index.tsx`: cria a raiz React e monta `App`;
- `public/`: arquivos públicos do Create React App.

## Como executar

Na pasta da tarefa:

```bash
npm install
npm start
```

O navegador abrirá a aplicação em modo de desenvolvimento. Também estão disponíveis `npm run build` para gerar a versão de produção e `npm test` para iniciar o executor de testes.

## Tecnologias

React, React DOM, TypeScript 4.9.5, CSS e Create React App.
