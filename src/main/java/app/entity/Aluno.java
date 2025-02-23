package app.entity;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "O campo nome do aluno é obrigatório")
	@Pattern(regexp = "\\S+\\s+\\S+.*$", message = "O nome deve conter duas palavras")
	private String nome;
	
	@CPF(message = "O CPF deve ser válido!")
	private String cpf;
	
	private String telefone;
	
	private boolean cadastroCompleto;
	
	@ManyToOne
	private Turma turma;
}
