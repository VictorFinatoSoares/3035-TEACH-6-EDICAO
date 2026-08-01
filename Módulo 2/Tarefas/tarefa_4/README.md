# Tarefa 4 — Lista de tarefas com Context API

Aplicação React e TypeScript para gerenciar uma lista de tarefas. O estado e as operações ficam centralizados em um contexto, enquanto componentes menores cuidam da entrada, tabela e ações de cada linha.

## Funcionalidades

- adicionar tarefas;
- listar tarefas em uma tabela;
- alternar o estado de conclusão;
- excluir itens;
- aplicar um estilo diferente às tarefas concluídas.

## Conceitos praticados

- composição de componentes;
- tipagem de objetos e propriedades com interfaces;
- estado com `useState`;
- criação de contexto com `createContext`;
- fornecimento de estado e ações por um Provider;
- consumo do contexto com `useContext`;
- atualizações imutáveis com spread, `map` e `filter`;
- renderização de coleções com chaves.

## Organização dos componentes

- `App.tsx`: renderiza o contêiner principal;
- `Container.tsx`: envolve a lista com `TaskProvider`;
- `TaskContext.tsx`: define os tipos, o estado e as ações de adicionar, concluir e excluir;
- `TasksList.tsx`: combina entrada e tabela;
- `TaskInput.tsx`: controla o texto e solicita a inclusão;
- `TaskTable.tsx`: percorre a lista;
- `TaskRow.tsx`: exibe uma tarefa e seus controles.

## Como executar

```bash
npm install
npm start
```

Use `npm run build` para criar a versão de produção. O estado é mantido somente em memória e reinicia quando a página é recarregada.

## Tecnologias

React, Context API, TypeScript 4.9.5, CSS e Create React App.
