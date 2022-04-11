package com.contabancaria.cliente;

import java.util.List;
import java.util.Scanner;

import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;


public class MainDeletAll {

	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		//Deleta todos as dados do Banco
		System.out.println("Para Confirmar a Exclução Dos Dados  Digite 'confirmar'");
		
		//Confirmação Para Exclução de Todos os Dados
		if(!leitor.nextLine().toUpperCase().equals("CONFIRMAR")) {
			System.out.println("Processo Cancelado");
			
		}else {
			//Caso seja confirmado, todos os dados serão excluidos
			try {
				List<Pessoa> usuarios = dao.getAll();
				for (Pessoa usuario : usuarios) {
					dao.delete(usuario);
					System.out.println("Dados Excluidos....");
				}
			} finally {
				dao.close();
				leitor.close();
			}

		}
	
	}
}
