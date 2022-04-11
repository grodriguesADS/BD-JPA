package com.contabancaria.cliente;

import java.util.List;

import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;

public class MainGetAllConta {

	public static void main(String[] args) throws PersistenciaDacException {
		UserDAO dao = new UserDAO();
		try {
			//Salva todos os usuarios salvos no banco
			List<Pessoa> usuarios = dao.getAll();
			
			//Depois printa ultilizando um for
			for (Pessoa user : usuarios) {
				System.out.println("id: " + user.getConta().getID() + " | "  + "Nome do Cliente: " + user.getNome() + " | " + "Agencia: " + user.getConta().getAgencia() + " | " + "numero: " + user.getConta().getNumero());
			}

		} finally {
			dao.close();
		}
	}
	}

