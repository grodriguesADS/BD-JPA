package dac;

import java.util.Date;

import dao.PessoaDao;
import entidades.Pessoa;

public class MainGetByID {

	public static void main(String[] args) throws DacException {
		PessoaDao dao = new PessoaDao();
		try {
			// Primeiro salvar
	/*		Pessoa user = new Pessoa();

			user.setNome("Tarcizo");
			user.setSexo("Masculino");

			dao.save(user);
*/
			// Depois recuperar pelo identificador

			Pessoa resultado = dao.getByID(9);

			System.out.println(resultado.getNome());
		} finally {
			dao.close();
		}
	}

}
