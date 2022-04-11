package com.contabancaria.cliente.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class ContaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column (name = "saldo")
	private float saldo;
	
	@Column (name = "agencia")
	private String agencia;
	
	@Column (name = "numero")
	private String numero; 
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_fk", nullable = true)
	private Pessoa titular;
	
	public float getID() {
		return id;
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

}
