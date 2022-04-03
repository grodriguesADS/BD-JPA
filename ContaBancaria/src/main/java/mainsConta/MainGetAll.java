package mainsConta;

import java.util.List;

import dao.ContaDao;
import dao.PersistenciaDacException;
import entidades.ContaBancaria;

public class MainGetAll {

	public static void main(String[] args) throws DacException, PersistenciaDacException {

		ContaDao dao = new ContaDao();
		try {
			List<ContaBancaria> conta = dao.getAll();

			for (ContaBancaria user : conta) {
				System.out.println(user);
			}

		} finally {
			dao.close();
		}
	}

}
