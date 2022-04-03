package mainsConta;



import dao.ContaDao;
import dao.PersistenciaDacException;
import entidades.ContaBancaria;


public class MainDelete {

	public static void main(String[] args) throws DacException, PersistenciaDacException {
		ContaDao dao = new ContaDao();
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
			ContaBancaria conta =new ContaBancaria();
			conta = dao.getByID(11);
			dao.delete(conta);

//			System.out.println(dao.getAll().size());
			System.out.println("Conta " + conta.getNumero() + " " + conta.getId() + " " + "Deletada");
		} finally {
			dao.close();
		}
	}

}
