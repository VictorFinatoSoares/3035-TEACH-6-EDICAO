# Football App ⚽

Aplicação desenvolvida em React para consultar ligas de futebol, temporadas disponíveis e tabelas de classificação.

Os dados são obtidos por meio da API pública [Football Standings API](https://football-standings-api.vercel.app).

## Funcionalidades

- Listagem de ligas de futebol;
- Navegação para a classificação de cada liga;
- Consulta das temporadas disponíveis;
- Alteração da temporada exibida;
- Tabela com posição, pontuação e desempenho dos times;
- Indicador de carregamento durante as requisições;
- Layout responsivo.

## Tecnologias

- React
- TypeScript
- Vite
- React Router DOM
- Axios
- Tailwind CSS

## Como executar

### Pré-requisitos

Antes de começar, instale:

- [Node.js](https://nodejs.org/)
- npm, incluído na instalação do Node.js

### Instalação

Clone o repositório e acesse a pasta do projeto:

```bash
git clone URL_DO_REPOSITORIO
cd AulaFinal
```

Instale as dependências:

```bash
npm install
```

Inicie o servidor de desenvolvimento:

```bash
npm run dev
```

Depois, abra no navegador o endereço exibido pelo Vite. Normalmente:

```text
http://localhost:5173
```

## Scripts disponíveis

```bash
npm run dev
```

Inicia a aplicação em modo de desenvolvimento.

```bash
npm run build
```

Executa a verificação do TypeScript e gera o build de produção.

```bash
npm run lint
```

Analisa o código com ESLint.

```bash
npm run preview
```

Executa localmente uma prévia do build de produção.

## Rotas

| Rota                   | Descrição                                 |
| ---------------------- | ----------------------------------------- |
| `/`                    | Exibe a lista de ligas                    |
| `/standings/:leagueId` | Exibe a classificação da liga selecionada |

O parâmetro `leagueId` identifica a liga que será consultada.

Exemplo:

```text
/standings/bra.1
```

## Estrutura do projeto

```text
src/
├── components/
│   ├── Card.tsx
│   ├── Header.tsx
│   ├── Select.tsx
│   ├── Spinner.tsx
│   └── Table.tsx
├── Context/
│   └── LoadingContext.tsx
├── pages/
│   ├── Content.tsx
│   └── LeaguesStandings.tsx
├── services/
│   ├── api.ts
│   └── leagues.service.ts
├── App.tsx
├── index.css
└── main.tsx
```

### Componentes

- `Card`: apresenta uma liga e realiza a navegação para sua classificação;
- `Header`: cabeçalho compartilhado entre as páginas;
- `Select`: permite selecionar uma temporada;
- `Spinner`: apresenta o indicador de carregamento;
- `Table`: monta a tabela de classificação.

### Páginas

- `Content`: consulta e exibe as ligas disponíveis;
- `LeaguesStandings`: consulta as temporadas e a classificação de uma liga.

### Serviços

- `api.ts`: cria uma instância do Axios com a URL-base da API;
- `leagues.service.ts`: centraliza as requisições relacionadas às ligas.

### Contexto

O `LoadingContext` compartilha o estado de carregamento entre os componentes da aplicação.

## Endpoints utilizados

```http
GET /leagues
```

Retorna as ligas disponíveis.

```http
GET /leagues/:leagueId/seasons
```

Retorna as temporadas disponíveis para uma liga.

```http
GET /leagues/:leagueId/standings?season=:season&sort=asc
```

Retorna a classificação de uma liga em determinada temporada.

## Fluxo da aplicação

1. A página inicial consulta as ligas;
2. O usuário seleciona uma liga;
3. O ID da liga é colocado na URL;
4. A página de classificação lê esse ID com `useParams`;
5. As temporadas disponíveis são consultadas;
6. A primeira temporada é selecionada;
7. A classificação correspondente é exibida;
8. O usuário pode selecionar outra temporada.

## Objetivo do projeto

Este projeto foi desenvolvido para praticar conceitos como:

- Componentização com React;
- Propriedades e estados;
- Hooks `useState`, `useEffect`, `useContext`, `useParams` e `useNavigate`;
- Rotas dinâmicas;
- Context API;
- Requisições HTTP com Axios;
- Tipagem com TypeScript;
- Estilização com Tailwind CSS.

## Observação

A aplicação depende de uma API externa. Caso ela esteja indisponível, as ligas e classificações podem não ser carregadas.

## Licença

Este projeto foi desenvolvido para fins educacionais.
