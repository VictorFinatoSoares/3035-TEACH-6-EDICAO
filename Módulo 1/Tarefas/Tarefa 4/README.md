# Tarefa 4 — Sorteador de cores

Aplicação web simples que altera a cor de um quadrado quando o usuário aciona o botão. A nova cor é produzida em JavaScript a partir de valores RGB aleatórios.

## O que é praticado

- seleção de elementos do DOM com `getElementById`;
- criação de uma função para gerar valores aleatórios;
- composição dinâmica de uma cor RGB;
- escuta do evento de clique com `addEventListener`;
- alteração de estilos de um elemento via JavaScript;
- integração entre HTML, CSS e JavaScript.

## Arquivos

- `index.html`: título, quadrado e botão de ação;
- `style.css`: layout e aparência da interface;
- `script.js`: geração da cor e tratamento do clique.

## Como executar

Abra `index.html` em um navegador e clique no botão para sortear novas cores. Não há dependências externas.

## Fluxo da aplicação

1. O clique dispara o manipulador registrado no botão.
2. A função `corAleatoria` cria três números entre 0 e 255.
3. Os valores formam uma string `rgb(...)`.
4. A cor é aplicada ao fundo do quadrado.
