package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	

	public String save(Curso cursoModel) {
		this.cursoRepository.save(cursoModel);
		return "Curso salvo com sucesso!";
	}

	public Curso findById(long id) {
		return this.cursoRepository.findById(id).get();
	}

	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	public String update(Curso cursoModel, long id) {
		cursoModel.getId();
		this.cursoRepository.save(cursoModel);
		return "Curso atualizado com sucesso!";
	}

	public String delete(long id) {
		this.cursoRepository.deleteById(id);
		return "Curso removido com sucesso";
	}
	
	public Curso findByNomeIgnoreCase(String nome) {
		return this.cursoRepository.findByNomeIgnoreCase(nome);
	}
}
