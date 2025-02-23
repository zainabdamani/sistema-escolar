package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		validarEmail(professor.getEmail());
		if(professorRepository.existsByEmail(professor.getEmail())) {
			throw new RuntimeException("Email já cadastrado");
		}
		
		this.professorRepository.save(professor);
		return "Professor salvo com sucesso!";
	}

	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}

	public List<Professor> findAll() {
		return this.professorRepository.findAll();
	}

	public String update(Professor professorModel, long id) {
		professorModel.setId(id);
		this.professorRepository.save(professorModel);
		return "Professor atualizado com sucesso";
	}

	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "Professor removido com sucesso!";
	}
	
	public List<Professor> findByNameOrSpeciality(String nome){
		return this.professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, nome);
	}
	
	public List<Professor> findByTeacherNotGmail(){
		return this.professorRepository.findByEmailNotContainingGmail();
	}

	public Professor findByEmail(String email) {
		return this.professorRepository.findByEmail(email);
	}
	
	private void validarEmail(String email) {
		if(email.contains("@outlook.com")) {
			throw new RuntimeException("Dominio não permitido");
		}
	}
}
