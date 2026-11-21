package br.com.escola.controlecursos.repository;

import br.com.escola.controlecursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNomeContainingIgnoreCaseOrderByNome(String nome);
}
