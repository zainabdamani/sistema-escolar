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

import app.entity.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turmaModel){
		try {
			String message = this.turmaService.save(turmaModel);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Deu Ruim!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable long id){
		try {
			Turma turmaModel = turmaService.findById(id);
			return new ResponseEntity<>(turmaModel, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll(){
		try {
			List<Turma> list = this.turmaService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByClassYear")
	public ResponseEntity<List<Turma>> findByClassYear(int ano1, int ano2){
		try {
			return new ResponseEntity<>(this.turmaService.findByClassPerYear(ano1, ano2), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findBySemestreAndAno")
	public ResponseEntity<List<Turma>> findBySemestreAndAno(String semestre, int ano){
		try {
			return new ResponseEntity<>(this.turmaService.findBySemestreAndAno(semestre, ano), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNomeAndTurno")
	public ResponseEntity<List<Turma>> findByNomeAndTurno(String nome, String turno){
		try {
			return new ResponseEntity<>(this.turmaService.findByNomeAndTurno(nome, turno), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<Turma> findByNome(@RequestParam String nome){
		try {
			return new ResponseEntity<>(turmaService.findByNome(nome), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Turma turmaModel, @PathVariable long id){
		try {
			String message = this.turmaService.update(turmaModel, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String message = this.turmaService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
