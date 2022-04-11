package com.contabancaria.cliente;

import java.util.Scanner;

import com.contabancaria.cliente.model.ContaBancaria;
import com.contabancaria.cliente.model.Pessoa;
import com.contabancaria.cliente.model.Sexo;

import br.edu.ifpb.mt.dac.SaveDAO;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;

public class Main {
	
	
	public static void main(String[] args) throws PersistenciaDacException {
			Scanner leitor = new Scanner(System.in);
			//Criando Cliente
			Pessoa user = new Pessoa();
			System.out.print("Insira seus dados!! \nNome: ");
			user.setNome(leitor.nextLine());
			int i = 0;
			while(i == 0) {
			System.out.println("1 - Masculino \n2 - Feminino");
			System.out.print("Sexo: ");
			switch (Integer.parseInt(leitor.nextLine())) {
			case 1:
				user.setSexo(Sexo.MASCULINO);
				i--;
				break;
			case 2:
				user.setSexo(Sexo.FEMININO);
				i--;
				break;
			default:
				 System.out.println("Valor Invalido");
			}
		}
			//Criando Conta
			ContaBancaria cb = new ContaBancaria();
			System.out.println("Insira os dados da conta!!");
			System.out.print("Agencia: ");
			cb.setAgencia(leitor.nextLine());
			System.out.print("Numero: ");
			cb.setNumero(leitor.nextLine());
			
			
			//Salvando no banco de dados
			SaveDAO sv = new SaveDAO();
			sv.SalvarCliente(user, cb);
			
			leitor.close();
			
	}
}
