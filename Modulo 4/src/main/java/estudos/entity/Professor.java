package estudos.entity;

import java.time.LocalDate;

public class Professor extends Pessoa{

    private String disciplina;

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Professor(String nome, LocalDate dataNascimento, String disciplina) {
        super(nome, dataNascimento);
        this.disciplina = disciplina;
    }
}
