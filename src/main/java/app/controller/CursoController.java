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

import app.entity.Curso;
import app.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Curso cursoModel){
		try {
			String message = this.cursoService.save(cursoModel);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Deu Ruim!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Curso> findById(@PathVariable long id){
		try {
			Curso cursoModel = cursoService.findById(id);
			return new ResponseEntity<>(cursoModel, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<Curso> findByNome(@RequestParam String nome){
		try {
			return new ResponseEntity<>(this.cursoService.findByNomeIgnoreCase(nome), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Curso>> findAll(){
		try {
			List<Curso> list = this.cursoService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Curso cursoModel, @PathVariable long id){
		try {
			String message = this.cursoService.update(cursoModel, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String message = this.cursoService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
