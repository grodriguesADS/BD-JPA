package com.contabancaria.cliente;

import java.util.Date;
import java.util.Scanner;


import com.contabancaria.cliente.model.Pessoa;
import com.contabancaria.cliente.model.Sexo;

import br.edu.ifpb.mt.dac.DacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;


public class MainUpdate {

	public static void main(String[] args) throws DacException {
		Scanner leitor = new Scanner(System.in);
		
		UserDAO dao = new UserDAO();
		try {	
			//Id do cliente que deseja alterar os dados
			System.out.println("Qual o ID do Cliente Que Deseja Alterar:");
			int id = Integer.parseInt(leitor.nextLine());
			Pessoa user = dao.getByID(id);
			String sair = "n";	
			//Dados atuais do Cliente e da Conta
			System.out.println("Dados Do Cliente");
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
			
			System.out.println("Dados Da Conta");
			System.out.println("id: " + user.getConta().getID() + " | "  + "Nome do Cliente: " + user.getNome() + " | " + "Agencia: " + user.getConta().getAgencia() + " | " + "numero: " + user.getConta().getNumero());
			
			//Seleção doque Deseja Alterar
			while(!sair.equals("s")) {
				System.out.println("Qual Dado Deseja Atualizar"
						+ "\n 1- Nome"
						+ "\n 2- Sexo"
						+ "\n 3- Agencia"
						+ "\n 3- Conta"
						+ "\n S- Sair");
				String op = leitor.nextLine();

				switch (op) {
				//Alteração do Nome
				case "1":
					System.out.println("Qual o Novo Nome:");
					user.setNome(leitor.nextLine());
					break;
				//Alteração do Sexo	
				case"2":
					System.out.println("Qual o Novo Sexo:");
					System.out.println("M- Masculino F-Feminino");
					String sexo = leitor.nextLine().toUpperCase();
					if(sexo.equals("M")){
						user.setSexo(Sexo.MASCULINO);
					}else if(sexo.equals("F")){
						user.setSexo(Sexo.FEMININO);
					}else {
						System.out.println("Sexo Invalido");
					}
					break;
				//Alteração da Agencia
				case"3":
					System.out.println("Qual o Novo numero da Agencia:");
					user.getConta().setAgencia(leitor.nextLine());
					break;

				//Alteração da Conta					
				case"4":
					System.out.println("Qual o Novo Numero da Conta:");
					user.getConta().setNumero(leitor.nextLine());
					break;
					
				case"s":
					System.out.println("Saindo....");
					sair = "s";
					break;
					
				default:
					System.out.println("Opção Invalida");
					break;
				}
				
				
			}
			
			
			dao.update(user);
						
			//Novos Dados 
			System.out.println("--Dados Atualizados--");
			System.out.println("Dados Da Cliente");
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
			
			System.out.println("Dados Da Conta");
			System.out.println("id: " + user.getConta().getID() + " | "  + "Nome do Cliente: " + user.getNome() + " | " + "Agencia: " + user.getConta().getAgencia() + " | " + "numero: " + user.getConta().getNumero());

		} finally {
			dao.close();
		}
		
	}

}