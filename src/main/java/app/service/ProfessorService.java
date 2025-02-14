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
		this.professorRepository.save(professor);
		return "O professor "+professor.getNome()+" foi salvo com sucesso!";
	}


	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}


	public List<Professor> findAll(){
		return this.professorRepository.findAll();
	}

	public String update(Professor professor, long id) {
		return "O professor " + professor.getNome() + " foi atualizado com sucesso!";
	}


	public String delete(long id) {
		return "O professor foi deletado com sucesso!";
	}
}
