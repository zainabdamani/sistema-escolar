package app.entity;

import jakarta.persistence.Id;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)+$", message = "O nome deve conter um sobrenome!")
	private String nome;
	
	@CPF(message = "O CPF deve ser válido!")
	private String cpf;
	
	@Email(message = "O e-mail deve ser válido!")
	private String email;
	
	@Pattern(regexp = "^(?:$|[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)+)$", message = "A especialidade deve conter dois nomes ou mais!")
	private String especialidade;
	
	@ManyToMany
	@JoinTable(name="professor_turma")
	private List<Turma> turmas;
	
}
