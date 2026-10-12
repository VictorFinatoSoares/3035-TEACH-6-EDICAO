# Módulo 4 — Java e orientação a objetos

Este módulo aprofunda a programação com **Java** por meio da orientação a objetos. Os exemplos e exercícios mostram como encapsular dados, reutilizar comportamentos e tratar situações excepcionais.

## Conteúdos estudados

- classes, objetos, atributos e métodos;
- construtores;
- encapsulamento com modificadores de acesso;
- getters e setters;
- composição de comportamentos;
- enums;
- herança;
- sobrescrita de métodos;
- polimorfismo;
- interfaces;
- tratamento de exceções com `try`, `catch` e `finally`;
- collections da biblioteca padrão do Java;
- expressões lambda e uso de interfaces funcionais.

## Organização

```text
Modulo 4/
├── src/main/java/
│   ├── estudos/
│   │   ├── exceptions/
│   │   ├── polimorfismo/
│   │   ├── Jogador.java
│   │   ├── Main.java
│   │   └── Posicao.java
│   └── exercicios/
│       ├── exceptions/
│       └── pilares_poo/
├── pom.xml
└── README.md
```

### Estudos

A pasta `estudos` reúne exemplos usados para acompanhar as aulas:

- `Jogador`, `Posicao` e `Main` demonstram atributos, construtor, encapsulamento, enum e métodos;
- `polimorfismo` apresenta uma abstração comum de brinquedos com implementações de avião e barco;
- `exceptions` demonstra a captura de `NumberFormatException` e `ArithmeticException`, além do uso de `finally`.

### Exercícios

`exercicios/pilares_poo` contém três práticas:

1. criação de uma classe `Carro` com construtor e descrição;
2. herança entre `Animal`, `Cachorro` e `Gato`;
3. implementação da interface `Forma` por `Circulo` e `Retangulo`.

`exercicios/exceptions` reúne atividades de `try-catch`, tratamento de múltiplas exceções e `try-catch-finally`. Os enunciados completos estão nos arquivos `ENUNCIADOS.md` de cada pasta.

O módulo também trabalha collections, como listas, conjuntos e mapas, e expressões lambda para representar comportamentos de forma concisa e trabalhar com interfaces funcionais.

## Como executar

O projeto usa Maven e possui um `pom.xml` na raiz do módulo. Com o Java e o Maven instalados, execute:

```bash
mvn compile
```

As classes podem ser executadas pela IDE ou pelo terminal depois da compilação. Por exemplo:

```bash
java -cp target/classes estudos.Main
java -cp target/classes estudos.polimorfismo.Main
java -cp target/classes estudos.exceptions.Main
```

Para executar um exercício, use o nome completo do pacote correspondente, como:

```bash
java -cp target/classes exercicios.pilares_poo.ex01.Main
java -cp target/classes exercicios.exceptions.ex01.Main
```

> O `target/` e os arquivos de configuração das IDEs são gerados localmente e não fazem parte do conteúdo versionado.
