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

import app.entity.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professorModel){		
		try {
			return new ResponseEntity<>(this.professorService.save(professorModel), HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Professor> findById(@PathVariable long id){
		try {
			Professor professorModel = professorService.findById(id);
			return new ResponseEntity<>(professorModel, HttpStatus.OK);
		} catch(Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Professor>> findAll(){
		try {
			List<Professor> list = this.professorService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNameOrSpeciality")
	public ResponseEntity<List<Professor>> findByNameOrSpeciality(@RequestParam String nome){
		try {
			return new ResponseEntity<>(this.professorService.findByNameOrSpeciality(nome), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByTeacherNotGmail")
	public ResponseEntity<List<Professor>> findByTeacherNotGmail(){
		try {
			return new ResponseEntity<>(this.professorService.findByTeacherNotGmail(), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByTeacherEmail")
	public ResponseEntity<Professor> findByTeacherEmail(@RequestParam String email){
		try {
			return new ResponseEntity<>(this.professorService.findByEmail(email), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Professor professorModel, @PathVariable long id){
		try {
			String message = this.professorService.update(professorModel, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) { 
			return new ResponseEntity<>("Deu ruim!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String message = this.professorService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
