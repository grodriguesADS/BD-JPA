package mainsConta;

import java.util.Date;

import dao.ContaDao;
import entidades.ContaBancaria;

public class MainUpdate {

	public static void main(String[] args) throws DacException {
		ContaDao dao = new ContaDao();
		try {
			// Primeiro salvar
			ContaBancaria conta = new ContaBancaria();

			conta.setBirthday(new Date());
			conta.setEmail("email@gmail.com");
			conta.setFirstName("Sicrano");
			conta.setLastName("Silva");

			dao.save(conta);

			System.out.println(conta);

			// Depois atualizar
			conta.setFirstName("Beltrano");

			dao.update(conta);

			System.out);
		} finally {
			dao.close();
		}
	}

}
