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
	

	public String save(Curso curso) {
		this.cursoRepository.save(curso);
		return "O curso "+curso.getName()+" foi salvo com sucesso!";
	}


	public Curso findById(long id) {
		return this.cursoRepository.findById(id).get();
	}


	public List<Curso> findAll(){
		return this.cursoRepository.findAll();
	}

	public String update(Curso curso, long id) {
		return "O curso " + curso.getName() + " foi atualizado com sucesso!";
	}


	public String delete(long id) {
		return "O curso foi deletado com sucesso!";
	}
}
