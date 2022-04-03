package dac;



import dao.PessoaDao;
import entidades.Pessoa;


public class MainDelete {

	public static void main(String[] args) throws DacException {
		PessoaDao dao = new PessoaDao();
		try {
			// Primeiro salvar
//			Pessoa user = new Pessoa();
//
//			user.setBirthday(new Date());
//			user.setEmail("email@gmail.com");
//			user.setFirstName("Sicrano");
//			user.setLastName("Silva");
//
//			dao.save(user);
//
//			System.out.println(dao.getAll().size());

			// Depois apagar
			Pessoa user =new Pessoa();
			user = dao.getByID(11);
			dao.delete(user);

//			System.out.println(dao.getAll().size());
			System.out.println("Pessoa " + user.getNome() + " " + user.getId() + " " + "Deletada");
		} finally {
			dao.close();
		}
	}

}
