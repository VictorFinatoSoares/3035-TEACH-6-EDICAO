# Sistema de Controle de Cursos

Aplicação de console em Java 17 com Spring Data JPA e PostgreSQL para gerenciar alunos, cursos e matrículas.

## Estrutura

- `src/main/java/br/com/escola/controlecursos/`: código-fonte da aplicação, organizado por responsabilidade (`cli`, `model`, `repository` e `service`).
- `src/main/resources/`: configuração da aplicação.
- `docs/enunciado.pdf`: enunciado do desafio.
- `pom.xml`: dependências e configuração do Maven.

## Requisitos

- Java 17 ou superior
- Maven 3.6+
- PostgreSQL

## Preparar o banco

Crie um banco vazio no PostgreSQL:

```sql
CREATE DATABASE escola_cursos;
```

Por padrão, a aplicação usa `localhost:5432`, usuário `postgres` e senha `postgres`. Configure credenciais diferentes por variáveis de ambiente `DB_URL`, `DB_USER` e `DB_PASSWORD`.

## Executar

```bash
mvn spring-boot:run
```

O Hibernate cria/atualiza as tabelas na primeira execução. Para gerar um pacote executável: `mvn package` e depois `java -jar target/controle-cursos-1.0.0.jar`.

## Funcionalidades

- Cadastro e listagem de alunos; busca por e-mail.
- Cadastro e listagem de cursos; busca por nome parcial, sem diferenciar maiúsculas de minúsculas.
- Matrícula de aluno em curso; listagem exibe os nomes do aluno e curso.
- Um aluno não pode ser cadastrado duas vezes com o mesmo e-mail nem matriculado duas vezes no mesmo curso.

Cada matrícula possui relacionamentos `ManyToOne` com aluno e curso. As entidades usam JPA e os repositórios Spring Data executam as consultas no PostgreSQL.
