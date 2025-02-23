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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Aluno;
import app.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno alunoModel){
		try {
			String message = this.alunoService.save(alunoModel);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id){
		try {
			Aluno alunoModel = alunoService.findById(id);
			return new ResponseEntity<>(alunoModel, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Aluno>> findAll(){
		try {
			List<Aluno> list = this.alunoService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findByNomeStarting")
	public ResponseEntity<List<Aluno>> findByNomeStarting(@RequestParam String nome){
		try {
			return new ResponseEntity<>(this.alunoService.findByNomeStartingWith(nome), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findByTelefoneContaining")
	public ResponseEntity<List<Aluno>> findByTelefoneContaining(@RequestParam String telefone){
		try {
			return new ResponseEntity<>(this.alunoService.findByTelefoneContaining(telefone), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("findByTurma")
	public ResponseEntity<List<Aluno>> findByTurma(@RequestParam String nome){
		try {
			return new ResponseEntity<>(this.alunoService.findByTurmaNome(nome), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> update (@RequestBody Aluno alunoModel, @PathVariable long id){
		try {
			String message = this.alunoService.update(alunoModel, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String message = this.alunoService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
	

