# Tarefa 3 — Busca e seleção de filmes

Evolução da tarefa 2. Além de pesquisar e listar filmes, a aplicação permite selecionar um título por checkbox e informa qual filme está selecionado.

## Funcionalidades

- pesquisar filmes pelo nome;
- exibir ID, nome, gênero e capa em tabela;
- selecionar somente o filme correspondente ao estado atual;
- desmarcar o item selecionado;
- informar “Nenhum” quando não há seleção;
- mostrar uma mensagem quando a busca não retorna resultados.

## Conceitos praticados

- múltiplos estados com `useState`;
- inputs de texto e checkbox controlados;
- comparação entre estado e item renderizado;
- atualização condicional com operador ternário;
- filtragem e renderização de arrays;
- reaproveitamento incremental de uma solução anterior.

## Estrutura principal

- `src/App.tsx`: busca, seleção e renderização da tabela;
- `src/data/filmes.json`: catálogo local;
- `src/App.css`: estilização da interface e dos checkboxes;
- `src/index.tsx`: inicialização do React.

## Como executar

```bash
npm install
npm start
```

Para produção, execute `npm run build`. O projeto usa React, TypeScript 4.9.5 e Create React App.
