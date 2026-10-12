# Módulo 3 — Java básico e lógica

Este módulo marca a transição dos fundamentos de front-end para a programação com **Java**. Os exercícios praticam a sintaxe da linguagem, a entrada de dados pelo terminal e a construção de soluções usando expressões, condicionais e repetições.

## Conteúdos estudados

- estrutura básica de uma aplicação Java;
- declaração de variáveis e tipos primitivos;
- leitura de dados com `Scanner`;
- operadores aritméticos, relacionais e lógicos;
- estruturas condicionais;
- estruturas de repetição;
- organização do código em classes e métodos;
- geração de valores aleatórios;
- validação de entradas e menus interativos.

## Organização

```text
Modulo 3/
├── src/main/java/
│   ├── introducao/
│   │   └── Main.java
│   ├── exercicios/
│   │   ├── comparativo_logica/
│   │   ├── estrutura_condicional/
│   │   ├── estrutura_repeticoes/
│   │   └── estrutura_sequencial/
│   └── desafio/
│       └── GuessingGame.java
├── pom.xml
└── README.md
```

### Estudos e exercícios

As pastas dentro de `exercicios` reúnem atividades progressivas sobre:

- operações sequenciais e expressões;
- comparações e lógica booleana;
- decisões com `if`, `else` e `switch`;
- repetições com os diferentes tipos de laço.

A pasta `introducao` contém o primeiro contato com a execução de um programa Java e com a leitura de informações fornecidas pelo usuário.

### Desafio — jogo de adivinhação

`desafio/GuessingGame.java` contém um jogo de adivinhação executado no terminal. O programa possui:

- níveis fácil, médio e difícil;
- limite de tentativas e pontuação;
- dicas de maior ou menor;
- histórico de pontuações;
- histórico de recordes;
- loja de dicas;
- modo sequência, em que o jogador tenta descobrir três números;
- menu principal, regras e opção de encerramento.

## Como executar

O projeto usa Maven e possui um `pom.xml` na raiz do módulo. Com o Java e o Maven instalados, execute dentro desta pasta:

```bash
mvn compile
```

Para executar uma classe específica, compile o projeto e use o nome completo do pacote. Por exemplo:

```bash
mvn exec:java -Dexec.mainClass="desafio.GuessingGame"
```

Caso o plugin de execução não esteja disponível na instalação local, a classe também pode ser executada pela IDE ou diretamente pelo terminal após a compilação:

```bash
java -cp target/classes desafio.GuessingGame
```

Os exercícios podem ser executados substituindo o nome da classe pelo pacote correspondente, como `introducao.Main` ou `exercicios.estrutura_condicional.Ex01`.

> O `target/` contém arquivos gerados pela compilação e não faz parte do conteúdo versionado.
