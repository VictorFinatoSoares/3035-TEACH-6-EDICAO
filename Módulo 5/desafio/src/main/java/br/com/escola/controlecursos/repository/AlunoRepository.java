package br.com.escola.controlecursos.repository;

import br.com.escola.controlecursos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
