package br.com.escola.controlecursos.repository;

import br.com.escola.controlecursos.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByAlunoIdAndCursoId(Long alunoId, Long cursoId);
    @Query("select m from Matricula m join fetch m.aluno join fetch m.curso")
    List<Matricula> findAll();
}
