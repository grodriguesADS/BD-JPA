package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TB_CONTA")
public class ContaBancaria implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column()
	private int CPF;
	private float saldo;
	private String agencia;
	private String numero; 
	private Pessoa titular;
	
	
	public int getCPF() {
		return CPF;
	}
	
	public void setCPF(int cpf) {
		this.CPF = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Pessoa getTitular() {
		return titular;
	}
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}
	
	public ContaBancaria () {
		
	}
	
	public ContaBancaria (float saldoDaConta, String agenciaDoBanco, String numeroDaConta, Pessoa titularDaConta) {
		saldo = saldoDaConta;
		agencia = agenciaDoBanco;
		numero = numeroDaConta;
		titular = titularDaConta;
	}
	

	 public String toString () {
			return "User [id=" + id + "agencia" + agencia + "numero" + numero + "saldo" + saldo +"]";
	}

	public boolean equals (ContaBancaria CB) {
		if (agencia.equals(CB.getAgencia()) && numero.equals(CB.getNumero())) {
			return true;
		}
		return false;
	}
	
	  

}
