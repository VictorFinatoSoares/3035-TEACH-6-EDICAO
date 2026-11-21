package br.com.escola.controlecursos.cli;

import br.com.escola.controlecursos.model.*;
import br.com.escola.controlecursos.service.EscolaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenu implements CommandLineRunner {
    private final EscolaService service;
    private final Scanner scanner = new Scanner(System.in);
    public ConsoleMenu(EscolaService service) { this.service = service; }

    @Override public void run(String... args) {
        System.out.println("\n=== Sistema de Controle de Cursos ===");
        boolean ativo = true;
        while (ativo) {
            System.out.println("\n1 Cadastrar aluno | 2 Listar alunos | 3 Buscar aluno por e-mail");
            System.out.println("4 Cadastrar curso | 5 Listar cursos | 6 Buscar curso por nome");
            System.out.println("7 Realizar matrícula | 8 Listar matrículas | 0 Sair");
            try {
                switch (ler("Opção: ")) {
                    case "1" -> cadastrarAluno(); case "2" -> mostrar(service.listarAlunos());
                    case "3" -> System.out.println(service.buscarAluno(ler("E-mail: ")));
                    case "4" -> cadastrarCurso(); case "5" -> mostrar(service.listarCursos());
                    case "6" -> mostrar(service.buscarCurso(ler("Nome ou parte do nome: ")));
                    case "7" -> matricular(); case "8" -> mostrar(service.listarMatriculas());
                    case "0" -> ativo = false;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível concluir: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro ao acessar o banco de dados. Confira a conexão PostgreSQL e tente novamente.");
            }
        }
        System.out.println("Até logo!");
    }
    private void cadastrarAluno() {
        String nome = ler("Nome: "); String email = ler("E-mail: ");
        LocalDate nascimento = LocalDate.parse(ler("Data de nascimento (AAAA-MM-DD): "));
        System.out.println("Aluno cadastrado: " + service.cadastrarAluno(nome, email, nascimento));
    }
    private void cadastrarCurso() {
        String nome = ler("Nome do curso: "); String descricao = ler("Descrição: ");
        int carga = Integer.parseInt(ler("Carga horária em horas: "));
        System.out.println("Curso cadastrado: " + service.cadastrarCurso(nome, descricao, carga));
    }
    private void matricular() {
        mostrar(service.listarAlunos()); mostrar(service.listarCursos());
        long alunoId = Long.parseLong(ler("ID do aluno: "));
        long cursoId = Long.parseLong(ler("ID do curso: "));
        System.out.println("Matrícula realizada: " + service.matricular(alunoId, cursoId));
    }
    private String ler(String prompt) { System.out.print(prompt); return scanner.nextLine().trim(); }
    private <T> void mostrar(List<T> itens) {
        if (itens.isEmpty()) System.out.println("Nenhum registro encontrado.");
        else itens.forEach(System.out::println);
    }
}
