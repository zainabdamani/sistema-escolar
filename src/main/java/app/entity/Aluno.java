package app.entity;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
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
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)+$\r\n", message = "O nome deve conter um sobrenome!")
	private String nome;
	
	@CPF(message = "O CPF deve ser válido!")
	private String cpf;
	
	private String telefone;
	
	@ManyToOne
	private Turma turma;
}
