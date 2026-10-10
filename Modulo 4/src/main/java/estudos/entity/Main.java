package estudos.entity;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Cleomar", LocalDate.of(1991, 06, 12), 21);

        System.out.println(aluno.getDataNascimento());
        System.out.println(aluno.verificarCpf());

        Professor professor = new Professor("Cleomar Teach", LocalDate.of(1991, 06, 12), "Programação");

        System.out.println(professor.getNome());
        System.out.println(professor.getDisciplina());
        System.out.println(professor.verificarCpf());
    }
}
