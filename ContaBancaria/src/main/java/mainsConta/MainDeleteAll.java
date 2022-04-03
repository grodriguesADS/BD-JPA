package mainsConta;

import java.util.List;


import dao.ContaDao;
import dao.PersistenciaDacException;
import entidades.ContaBancaria;


public class MainDeleteAll {

	public static void main(String[] args) throws DacException, PersistenciaDacException {
		ContaDao dao = new ContaDao();
		try {
			List<ContaBancaria> contas = dao.getAll();
			for (ContaBancaria conta : contas) {
				dao.delete(conta);
			}
		} finally {
			dao.close();
		}
	}

}
