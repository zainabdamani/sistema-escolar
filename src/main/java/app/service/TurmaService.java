package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository turmaRepository;
	

	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return "A turma "+turma.getNome()+" foi salva com sucesso!";
	}


	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}


	public List<Turma> findAll(){
		return this.turmaRepository.findAll();
	}

	public String update(Turma turma, long id) {
		return "A turma " + turma.getNome() + " foi atualizada com sucesso!";
	}


	public String delete(long id) {
		return "A turma foi deletada com sucesso!";
	}
}
