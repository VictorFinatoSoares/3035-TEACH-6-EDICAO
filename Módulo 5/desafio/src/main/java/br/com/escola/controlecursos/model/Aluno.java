package br.com.escola.controlecursos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "alunos", uniqueConstraints = @UniqueConstraint(name = "uk_aluno_email", columnNames = "email"))
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, length = 120)
    private String nome;
    @NotBlank @Email @Column(nullable = false, length = 180)
    private String email;
    @NotNull @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    protected Aluno() {}
    public Aluno(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome; this.email = email; this.dataNascimento = dataNascimento;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    @Override public String toString() { return "#" + id + " | " + nome + " | " + email + " | nascimento: " + dataNascimento; }
}
