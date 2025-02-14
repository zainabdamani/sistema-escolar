package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Aluno;
import app.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			String mensagem = this.alunoService.save(aluno);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id){
		try {
			
			Aluno aluno = this.alunoService.findById(id);
			return new ResponseEntity<>(aluno, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Aluno>> findAll(){
		
		try {
			List<Aluno> lista = this.alunoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Aluno aluno, @PathVariable long id){
		try {
			
			String mensagem = this.alunoService.update(aluno, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			
			String mensagem = this.alunoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
}
