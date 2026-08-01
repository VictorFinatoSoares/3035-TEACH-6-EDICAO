# 3035 Teach — 6ª Edição | Formação Fullstack

Este repositório reúne os estudos, exercícios, tarefas e desafios desenvolvidos durante a **6ª edição do Teach**, programa gratuito de formação em programação oferecido pela empresa **3035**.

A trilha possui foco **fullstack** e acompanha uma progressão que começa nos fundamentos da web, avança para desenvolvimento de interfaces com React e segue para backend com Java, bancos de dados, Spring Boot e APIs.

## Sobre este repositório

O repositório funciona como registro da evolução ao longo do curso e como local de organização das entregas previstas em cada módulo. Ele não representa uma única aplicação: cada pasta contém um estudo, exercício ou projeto independente, criado de acordo com o conteúdo trabalhado naquele momento.

Entre os materiais armazenados estão:

- exemplos produzidos durante os estudos;
- tarefas práticas de fixação;
- desafios técnicos dos módulos;
- aplicações desenvolvidas com as tecnologias da trilha;
- documentação específica sobre o objetivo e o funcionamento de cada atividade.

## Organização atual

```text
3035-TEACH-6-EDICAO/
├── Módulo 1/
│   ├── Estudo/
│   │   ├── IntroduçãoHTML/
│   │   ├── IntroduçãoCSS/
│   │   └── IntroduçãoJS/
│   ├── Tarefas/
│   └── Desafio/
├── Módulo 2/
│   ├── TypeScript/
│   ├── React/
│   └── Tarefas/
└── README.md
```

### Módulo 1 — HTML, CSS e JavaScript

O [Módulo 1](./M%C3%B3dulo%201/) apresenta os fundamentos do desenvolvimento web:

- estrutura e semântica com HTML;
- formulários, tabelas, textos e mídias;
- estilização, Flexbox, Grid, responsividade e animações com CSS;
- lógica, funções, arrays, objetos e manipulação do DOM com JavaScript;
- criação de interfaces interativas sem frameworks;
- persistência de dados no navegador com `localStorage`.

A pasta é dividida entre conteúdos de estudo, seis tarefas progressivas e um desafio final de módulo.

### Módulo 2 — TypeScript e React

O [Módulo 2](./M%C3%B3dulo%202/) desenvolve aplicações front-end componentizadas e com tipagem estática:

- tipos, interfaces, propriedades opcionais e extensão de contratos com TypeScript;
- componentes e propriedades no React;
- estado e ciclo de vida com hooks;
- formulários e entradas controladas;
- renderização de listas e conteúdo condicional;
- compartilhamento de estado com Context API;
- estilização responsiva com CSS e Tailwind CSS;
- consumo assíncrono de APIs.

Os projetos deste módulo incluem exercícios isolados de TypeScript, conteúdos de React e seis tarefas práticas.

## Trilha fullstack prevista

O cronograma fornecido para a 6ª edição apresenta a seguinte sequência:

| Módulo | Tema | Período previsto |
| --- | --- | --- |
| 1 | Boas-vindas + HTML, CSS e JavaScript | 17/06 a 16/07/2026 |
| 2 | TypeScript + React | 17/07 a 04/09/2026 |
| 3 | Java básico + lógica | 05/09 a 04/10/2026 |
| 4 | Java + orientação a objetos | 05/10 a 04/11/2026 |
| 5 | Banco de dados — SQL + Java | 05/11 a 04/12/2026 |
| 6 | Spring Boot + APIs | 05/12/2026 a 15/01/2027 |
| 7 | Desafio final | 16/01 a 31/01/2027 |
| Encerramento | Certificados + feedbacks | Até 12/02/2027 |

> O cronograma é **previsto** e pode sofrer alterações. Segundo a orientação apresentada, a data final de cada módulo corresponde ao prazo máximo para a entrega dos desafios técnicos, atividades de soft skills e demais entregas daquele período.

## Evolução proposta pelo curso

A organização dos módulos constrói a formação em etapas:

1. **Fundamentos do front-end:** estrutura, apresentação e interatividade no navegador.
2. **Front-end moderno:** tipagem, componentização, gerenciamento de estado e integração com APIs.
3. **Fundamentos de backend:** lógica e programação com Java.
4. **Modelagem de aplicações:** orientação a objetos e organização do domínio.
5. **Persistência:** bancos de dados relacionais, SQL e integração com Java.
6. **Serviços web:** desenvolvimento de APIs com Spring Boot.
7. **Integração fullstack:** aplicação dos conhecimentos acumulados no desafio final.

## Como navegar pelo conteúdo

Cada atividade documentada possui seu próprio `README.md`, com informações que podem incluir:

- objetivo do exercício;
- conceitos praticados;
- funcionalidades implementadas;
- responsabilidade dos principais arquivos;
- tecnologias utilizadas;
- instruções de execução;
- observações sobre persistência, APIs ou limitações do projeto.

Para entender uma implementação, entre na pasta correspondente e consulte primeiro o README local.

## Como executar os projetos

Os comandos variam conforme a tecnologia usada em cada pasta.

### HTML, CSS e JavaScript

Projetos estáticos normalmente podem ser executados abrindo o arquivo `index.html` no navegador. Um servidor local, como o fornecido pelo Live Server, também pode ser utilizado.

### React

Nos projetos que possuem `package.json`, instale as dependências e consulte os scripts disponíveis:

```bash
npm install
npm start
```

Alguns projetos podem utilizar outra ferramenta de desenvolvimento e disponibilizar `npm run dev`. O `package.json` e o README da atividade são as referências corretas para cada caso.

### TypeScript

Exercícios isolados podem ser compilados com:

```bash
npx tsc
```

Quando houver saída JavaScript em `dist/`, ela poderá ser executada com Node.js conforme indicado no README daquela pasta.

## Tecnologias presentes e previstas

- HTML5;
- CSS3;
- JavaScript;
- TypeScript;
- React;
- Tailwind CSS;
- consumo de APIs HTTP;
- Java;
- SQL e bancos de dados relacionais;
- Spring Boot;
- desenvolvimento e integração de APIs.

## Finalidade

Além de atender às entregas do Teach, este repositório serve como histórico de aprendizagem. A separação por módulos permite acompanhar a evolução desde páginas estáticas até a construção prevista de uma aplicação fullstack, preservando os exercícios intermediários que fundamentam cada nova etapa.

---

Repositório educacional desenvolvido durante a **6ª edição do programa Teach da 3035**.
