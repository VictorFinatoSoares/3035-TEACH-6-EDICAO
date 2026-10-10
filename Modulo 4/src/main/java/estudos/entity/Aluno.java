package estudos.entity;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private int numeroMatricula;

    public Aluno(String nome, LocalDate dataNascimento, int numeroMatricula) {
        super(nome, dataNascimento);
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String verificarCpf() {
        return cpf == null ? "CPF não cadastrado!" : cpf;
    }

    public String verificarNome() {
        return nome == null ? "Nome não existe" : "Nome existe"; // Explicando o protected...
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
