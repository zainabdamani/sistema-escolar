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

	public String save(Turma turmaModel) {
		this.turmaRepository.save(turmaModel);
		return "Turma salva com sucesso!";
	}
	
	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}
	
	public List<Turma> findAll(){
		return this.turmaRepository.findAll();
	}
	
	public String update(Turma turmaModel, long id) {
		turmaModel.setId(id);
		this.turmaRepository.save(turmaModel);
		return "Turma atualizada com sucesso";
	}
	
	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "Turma removida com sucesso!";
	}
	
	public List<Turma> findByClassPerYear(int ano1, int ano2){
		return this.turmaRepository.findByAnoBetween(ano1, ano2);
	}
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano){
		return this.turmaRepository.findBySemestreAndAno(semestre, ano);
	}
	
	public List<Turma> findByNomeAndTurno(String nome, String turno){
		return this.turmaRepository.findByNomeAndTurno(nome, turno);
	}
	
	public Turma findByNome(String nome){
		return this.turmaRepository.findByNome(nome);
	}
}
