package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_PESSOA", uniqueConstraints = {
		@UniqueConstraint(name = "UC_CPF", columnNames = {"CPF"})
})
public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String CPF;
	private String nome;
	private String sexo;
	
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cpf) {
		this.CPF = cpf;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	public Pessoa (String nomeDaPessoa, String sexoDaPessoa) {
		nome = nomeDaPessoa;
		sexo = sexoDaPessoa;
	}
	public Pessoa () {
		
	}
	

	public boolean equals (Pessoa p) {
		if (id == p.getId()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		
		return result;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + "nome" + nome + "sexo" + sexo +"]";
	}


}
