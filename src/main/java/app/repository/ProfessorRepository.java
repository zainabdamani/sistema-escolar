package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
	
	@Query("SELECT p FROM Professor p WHERE p.email NOT LIKE '%@gmail.com'")
	List<Professor> findByEmailNotContainingGmail();

	Professor findByEmail(String email);
	
	boolean existsByEmail(String email);
	
}
