package br.edu.ifpb.mt.dac;


import com.contabancaria.cliente.model.ContaBancaria;
import com.contabancaria.cliente.model.Pessoa;

import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dao.UserDAO;


public class SaveDAO {

	public void SalvarCliente (Pessoa pessoa, ContaBancaria conta) throws PersistenciaDacException {
		UserDAO dao = new UserDAO();
		try {
			Pessoa p = new Pessoa();
			p.setNome(pessoa.getNome());
			p.setSexo(pessoa.getSexo());
			
			ContaBancaria cb = new ContaBancaria();
			cb.setAgencia(conta.getAgencia());
			cb.setNumero(conta.getNumero());
			
			//Associando conta ao cliente
			p.setConta(cb);
			cb.setTitular(p);
			

			dao.saveConta(cb);
			System.out.println("Salvo com sucesso!!");
		} finally {
			dao.close();
		}
	}

}
