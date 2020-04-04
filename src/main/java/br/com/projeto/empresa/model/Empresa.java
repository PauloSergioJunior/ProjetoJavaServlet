/**
 * 
 */
package br.com.projeto.empresa.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Paulo
 *
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;

	//private String nome;
	
	private String email = "paulo@gmail.com";
	
	private String senha = "123";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//private String cnpj;
	
	//private String descricao;
	
	
	
}
