# Tarefa 6 — Lista de tarefas

Aplicação de lista de tarefas construída com HTML, CSS e JavaScript puro. O usuário pode cadastrar itens, alternar o estado de conclusão, remover tarefas e filtrar o que está visível.

## Funcionalidades

- adicionar uma tarefa a partir do formulário;
- impedir a inclusão de texto vazio;
- marcar ou desmarcar uma tarefa como concluída;
- remover uma tarefa;
- filtrar por todas, pendentes ou concluídas;
- exibir a data de criação;
- atualizar o contador de pendências e total.

## Conceitos praticados

- arrays de objetos e identificadores gerados com `Date.now()`;
- operações `push`, `find`, `filter` e `forEach`;
- criação dinâmica de elementos HTML;
- eventos de formulário, checkbox e botão;
- estado mantido em memória e renderização derivada desse estado;
- classes CSS condicionais e atributos `data-*`.

## Arquivos

- `index.html`: formulário, filtros, lista e contador;
- `style.css`: layout e estados visuais da interface;
- `script.js`: regras de cadastro, conclusão, exclusão, filtro e renderização.

## Como executar

Abra `index.html` no navegador. As tarefas permanecem somente enquanto a página está aberta; ao recarregar, o array em memória volta ao estado inicial.
