package br.com.escola.controlecursos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas", uniqueConstraints = @UniqueConstraint(name = "uk_matricula_aluno_curso", columnNames = {"aluno_id", "curso_id"}))
public class Matricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    protected Matricula() {}
    public Matricula(Aluno aluno, Curso curso, LocalDate dataMatricula) {
        this.aluno = aluno; this.curso = curso; this.dataMatricula = dataMatricula;
    }
    public Long getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public Curso getCurso() { return curso; }
    public LocalDate getDataMatricula() { return dataMatricula; }
    @Override public String toString() { return "#" + id + " | aluno: " + aluno.getNome() + " | curso: " + curso.getNome() + " | data: " + dataMatricula; }
}
