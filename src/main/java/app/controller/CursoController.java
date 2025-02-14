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

import app.entity.Curso;
import app.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Curso curso){
		try {
			String mensagem = this.cursoService.save(curso);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Curso> findById(@PathVariable long id){
		try {
			
			Curso curso = this.cursoService.findById(id);
			return new ResponseEntity<>(curso, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Curso>> findAll(){
		
		try {
			List<Curso> lista = this.cursoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Curso curso, @PathVariable long id){
		try {
			
			String mensagem = this.cursoService.update(curso, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			
			String mensagem = this.cursoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
}
}
