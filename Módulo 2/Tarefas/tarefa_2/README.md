# Tarefa 2 — Catálogo de filmes com busca

Aplicação React que lê uma coleção local de filmes, apresenta seus dados em uma tabela e filtra os resultados enquanto o usuário digita no campo de busca.

## Funcionalidades

- listar ID, nome, gênero e capa dos filmes;
- busca por trecho do nome, sem diferenciar maiúsculas de minúsculas;
- atualização imediata da tabela;
- mensagem quando nenhum filme corresponde à pesquisa.

## Conceitos praticados

- estado controlado com `useState`;
- eventos de entrada com `onChange`;
- importação de dados JSON;
- filtragem com `filter`, `includes` e normalização com `toLowerCase`;
- renderização de listas com `map` e propriedade `key`;
- renderização condicional com operador ternário;
- atributos dinâmicos em JSX.

## Estrutura principal

- `src/App.tsx`: busca, filtragem e tabela;
- `src/data/filmes.json`: fonte local dos filmes;
- `src/App.css`: aparência do campo, tabela e capas;
- `src/index.tsx`: ponto de entrada da aplicação.

## Como executar

```bash
npm install
npm start
```

Use `npm run build` para gerar a versão de produção. O projeto foi configurado com React, TypeScript 4.9.5 e Create React App.
