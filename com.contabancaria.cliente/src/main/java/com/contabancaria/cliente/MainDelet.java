package com.contabancaria.cliente;

import java.util.Scanner;

import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;

public class MainDelet {

	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		
		UserDAO dao = new UserDAO();
		Pessoa user =new Pessoa();
		
		//Pede id do cliente que deseja excluir os dados
		System.out.println("Qual o ID do Cliente Que Deseja Excluir: ");
		int id = Integer.parseInt(leitor.nextLine());
		
		//Mostra os dados do Cliente que sera excluido
		System.out.println("Pessoa " + user.getNome() + " " + user.getId() + " " + "Deletada");
		
		//Caso seja esse, digite confirmar
		System.out.println("Deseja Exluir este cliente?  \n Caso sim digite 'CONFIRMAR'");
		
		if(leitor.nextLine().toUpperCase().equals("CONFIRMAR")) {
			//Caso confirmado os dados do cliente sera excluido do banco
			user = dao.getByID(id);
			dao.delete(user);
			System.out.println("Dados do Cliente Excluido");
		}else {
			System.out.println("Processo Cancelado");
		}

		

	}

}
