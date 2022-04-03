package mainsConta;



import dao.ContaDao;
import dao.PersistenciaDacException;

import entidades.ContaBancaria;


public class MainGetByID {

	public static void main(String[] args) throws DacException, PersistenciaDacException {
		ContaDao dao = new ContaDao();
		try {
			// Primeiro salvar
	/*		Pessoa user = new Pessoa();

			user.setNome("Tarcizo");
			user.setSexo("Masculino");

			dao.save(user);
*/
			// Depois recuperar pelo identificador

			ContaBancaria resultado = dao.getByID(9);

			System.out.println("ID: " + resultado.getId() + " Conta:" + resultado.getNumero());
		} finally {
			dao.close();
		}
	}

}
