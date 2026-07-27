# `Tarefa 6: Cards de Pokemon com API`

`Componentes principais:`

* App.tsx: Renderiza todos os componentes da página principal

* Header.tsx: Contém o cabeçalho da página (questão estética e opcional)

* Card.tsx: Contém a div que mostra nome e imagem do pokemon

* CardsList: Renderiza cada Card.tsx com base nas informações (e quantidades de informações)
* Vindas da API (https://pokeapi.co/api/v2/pokemon), limite pré-definido de 20 pokemons

`Detalhamento da Tarefa:`

* Cards responsivos, quanto menor a tela menos colunas de cards serão renderizados

* Header responsivo, ajusta o tamanho do texto dependendo do tamanho da tela

* Estilização simples feita com TailWindCSS

`OBS: Adicionei a requisição para pegar imagens como uma forma de treinar um pouco a mais a questão de requisições, inicialmente havia feito uma solução usando 2 fetchs com um for
 que realizava uma requisição procurando a imagem para o primeiro pokemon, esperava, e realizava para o segundo em diante, entretanto, pesquisei um pouco a mais e apliquei a solução com promise.all`

Precisa do TypeScript 4.9.5 
TailWind V3 (Usados para a tarefa)
  
