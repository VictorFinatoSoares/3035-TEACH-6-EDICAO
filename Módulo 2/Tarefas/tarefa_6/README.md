# Tarefa 6 — PokéCards com API

Aplicação React que consulta a PokéAPI e apresenta os Pokémon recebidos em cards responsivos. Cada card exibe o nome e a imagem obtida em uma segunda consulta ao endpoint de detalhes.

## Funcionalidades

- carregar a lista inicial de Pokémon ao montar a página;
- consultar os detalhes de cada item para obter sua imagem;
- aguardar as requisições paralelas com `Promise.all`;
- guardar o resultado tipado no estado;
- renderizar um card para cada Pokémon;
- adaptar a quantidade de colunas ao tamanho da tela.

## Conceitos praticados

- componentes e propriedades tipadas;
- estado de arrays com `useState`;
- efeitos de montagem com `useEffect`;
- funções assíncronas, `fetch`, `await` e leitura de JSON;
- transformação de coleções com `map`;
- paralelismo de promessas com `Promise.all`;
- renderização de listas com chaves estáveis;
- responsividade e efeitos de interação com Tailwind CSS.

## Fluxo dos dados

1. `CardsList` consulta `https://pokeapi.co/api/v2/pokemon`.
2. Para cada resultado, uma consulta ao endereço individual recupera `sprites.front_default`.
3. `Promise.all` reúne os objetos com nome, URL e imagem.
4. O estado `cards` é atualizado e a lista renderiza os componentes `Card`.

## Estrutura principal

- `src/App.tsx`: compõe o cabeçalho e a lista;
- `src/components/Header.tsx`: cabeçalho responsivo;
- `src/components/CardsList.tsx`: integração com a API e renderização da coleção;
- `src/components/Card.tsx`: apresentação de um Pokémon;
- `src/index.css`: diretivas do Tailwind CSS.

## Como executar

```bash
npm install
npm start
```

A consulta requer conexão com a internet e disponibilidade da PokéAPI. Para produção, use `npm run build`.

## Tecnologias

React, TypeScript 4.9.5, Fetch API, Tailwind CSS 3 e Create React App.
  
