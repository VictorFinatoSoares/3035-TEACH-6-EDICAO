package br.com.escola.controlecursos.service;

import br.com.escola.controlecursos.model.*;
import br.com.escola.controlecursos.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EscolaService {
    private final AlunoRepository alunos;
    private final CursoRepository cursos;
    private final MatriculaRepository matriculas;

    public EscolaService(AlunoRepository alunos, CursoRepository cursos, MatriculaRepository matriculas) {
        this.alunos = alunos; this.cursos = cursos; this.matriculas = matriculas;
    }
    public Aluno cadastrarAluno(String nome, String email, LocalDate nascimento) {
        if (alunos.existsByEmailIgnoreCase(email)) throw new IllegalArgumentException("Já existe aluno cadastrado com esse e-mail.");
        if (nascimento.isAfter(LocalDate.now())) throw new IllegalArgumentException("A data de nascimento não pode ser futura.");
        return alunos.save(new Aluno(nome.trim(), email.trim(), nascimento));
    }
    public Curso cadastrarCurso(String nome, String descricao, int carga) {
        if (carga <= 0) throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        return cursos.save(new Curso(nome.trim(), descricao == null ? "" : descricao.trim(), carga));
    }
    public Matricula matricular(Long alunoId, Long cursoId) {
        Aluno aluno = alunos.findById(alunoId).orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));
        Curso curso = cursos.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso não encontrado."));
        if (matriculas.existsByAlunoIdAndCursoId(alunoId, cursoId)) throw new IllegalArgumentException("Este aluno já está matriculado nesse curso.");
        return matriculas.save(new Matricula(aluno, curso, LocalDate.now()));
    }
    @Transactional(readOnly = true) public List<Aluno> listarAlunos() { return alunos.findAll(); }
    @Transactional(readOnly = true) public List<Curso> listarCursos() { return cursos.findAll(); }
    @Transactional(readOnly = true) public List<Matricula> listarMatriculas() { return matriculas.findAll(); }
    @Transactional(readOnly = true) public Aluno buscarAluno(String email) {
        return alunos.findByEmailIgnoreCase(email.trim()).orElseThrow(() -> new IllegalArgumentException("Nenhum aluno encontrado com esse e-mail."));
    }
    @Transactional(readOnly = true) public List<Curso> buscarCurso(String nome) { return cursos.findByNomeContainingIgnoreCaseOrderByNome(nome.trim()); }
}
