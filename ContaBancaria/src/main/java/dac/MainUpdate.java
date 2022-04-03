package dac;



import dao.PessoaDao;
import entidades.Pessoa;


public class MainUpdate {

	public static void main(String[] args) throws DacException {
		PessoaDao dao = new PessoaDao();
		try {
			// Primeiro salvar
			Pessoa user = new Pessoa();


			user.setNome("Sicrano");
			user.setSexo("Silva");

			dao.save(user);

			System.out.println(user);

			// Depois atualizar
			user.setNome("Beltrano");

			dao.update(user);

			System.out.println(user);
		} finally {
			dao.close();
		}
	}

}
