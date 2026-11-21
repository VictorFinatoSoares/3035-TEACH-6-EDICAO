package br.com.escola.controlecursos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false, length = 150)
    private String nome;
    @Column(length = 1000)
    private String descricao;
    @Min(1) @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;

    protected Curso() {}
    public Curso(String nome, String descricao, int cargaHoraria) {
        this.nome = nome; this.descricao = descricao; this.cargaHoraria = cargaHoraria;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getCargaHoraria() { return cargaHoraria; }
    @Override public String toString() { return "#" + id + " | " + nome + " | " + cargaHoraria + "h | " + (descricao == null ? "" : descricao); }
}
