package com.contabancaria.cliente;

import java.util.Scanner;

import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;

public class MainGetID {

	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		
		//Buscando no Banco de dados o id
		System.out.println("Qual o ID do Cliente que Deseja Consultar:");
		int id = Integer.parseInt(leitor.nextLine());
		
		Pessoa user = dao.getByID(id);
			
		if(user == null) {
			//Caso não encontre, avisa que o id não foi encontrado 
			System.out.println("Id não encontrado");
		}else {
			//Caso acha printa os dados
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());

		}

	}

}
