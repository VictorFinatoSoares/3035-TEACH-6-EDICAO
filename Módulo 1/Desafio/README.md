# Desafio final do Módulo 1 — PetShop

O desafio reúne HTML, CSS e JavaScript em um pequeno sistema de PetShop com três páginas conectadas. A aplicação permite cadastrar tutores e animais, consultar os clientes salvos e visualizar um catálogo de produtos.

## Funcionalidades

- navegação entre início, clientes e produtos;
- formulário com dados do tutor, atendimento e animal;
- validação básica por campos obrigatórios;
- persistência de clientes no `localStorage` do navegador;
- criação dinâmica de cards de clientes;
- modal com todos os detalhes do cadastro selecionado;
- fechamento do modal pelo botão ou pela área externa;
- catálogo de produtos criado a partir de um array JavaScript;
- ação de adicionar produto ao carrinho com mensagem de retorno.

## Conceitos aplicados

- HTML semântico e formulários;
- layout responsivo com Flexbox e Grid;
- eventos de envio e clique;
- objetos, arrays e iteração;
- criação e atualização de elementos do DOM;
- serialização com `JSON.stringify` e `JSON.parse`;
- armazenamento local compartilhado entre páginas da mesma origem;
- estados visuais, `hover`, modal e feedback ao usuário.

## Estrutura

- `index.html`: apresentação do PetShop e cadastro de clientes;
- `clientes.html`: listagem dos cadastros e modal de detalhes;
- `produtos.html`: catálogo de produtos;
- `script.js`: persistência, renderização dos clientes, modal e produtos;
- `style.css`: identidade visual e layout das três páginas.

## Como executar

Abra `index.html` em um navegador ou sirva esta pasta com Live Server. Para testar o fluxo completo:

1. preencha e envie o cadastro na página inicial;
2. abra a página **Clientes** para consultar o registro;
3. clique no card para visualizar os detalhes;
4. acesse **Produtos** para interagir com o catálogo.

## Persistência e dependências

Os clientes são armazenados no `localStorage` com a chave `clientes`. Os dados continuam disponíveis após atualizar a página, mas ficam limitados ao navegador e à origem utilizada. O projeto não exige pacotes; apenas as imagens remotas dos produtos dependem de internet.
