package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	

	public String save(Aluno aluno) {
		validarCadastro(aluno);
		
		if(alunoRepository.existsByCpf(aluno.getCpf())) {
			throw new RuntimeException("CPF já cadastrado!");
		}
		
		this.alunoRepository.save(aluno);
		return "Aluno salvo com sucesso!";
	}

	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}

	public List<Aluno> findAll() {
		return this.alunoRepository.findAll();
	}

	public String update(Aluno aluno, long id) {
		aluno.setId(id);
		validarCadastro(aluno);
		this.alunoRepository.save(aluno);
		return "Aluno atualizado com sucesso";
	}

	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno removido com sucesso";
	}
	
	public List<Aluno> findByNomeStartingWith(String nome) {
		return this.alunoRepository.findByNomeStartingWith(nome);
	}
	
	public List<Aluno> findByTelefoneContaining(String telefone){
		return this.alunoRepository.findByTelefoneContaining(telefone);
	}
	
	public List<Aluno> findByTurmaNome(String nome){
		return this.alunoRepository.findByTurmaNome(nome);
	}
	
	private void validarCadastro(Aluno aluno) {
		aluno.setCadastroCompleto(aluno.getTelefone() != null && !aluno.getTelefone().isEmpty());
	}
}
