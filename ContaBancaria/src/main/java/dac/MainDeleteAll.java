package dac;

import java.util.List;


import dao.PessoaDao;
import entidades.Pessoa;


public class MainDeleteAll {

	public static void main(String[] args) throws DacException {
		PessoaDao dao = new PessoaDao();
		try {
			List<Pessoa> usuarios = dao.getAll();
			for (Pessoa usuario : usuarios) {
				dao.delete(usuario);
			}
		} finally {
			dao.close();
		}
	}

}
