package com.contabancaria.cliente;

import java.util.List;

import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;

public class MainGetAllCliente {
	public static void main(String[] args) throws PersistenciaDacException {
		UserDAO dao = new UserDAO();
		try {
			//Salva todos os contas salvas no banco
			List<Pessoa> usuarios = dao.getAll();
			
			//Depois printa ultilizando um for
			for (Pessoa user : usuarios) {
				System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
			}

		} finally {
			dao.close();
		}
	}
	}

