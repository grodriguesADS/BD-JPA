package mainsConta;



import dao.ContaDao;
import dao.PersistenciaDacException;
import entidades.ContaBancaria;
import entidades.Pessoa;

public class MainSave {

	public static void main(String[] args) throws DacException, PersistenciaDacException {
		ContaDao dao = new ContaDao();
		try {
			ContaBancaria conta = new ContaBancaria();
			Pessoa pessoa = new Pessoa();


			conta.setId(0);
			conta.setAgencia("0923");
			conta.setNumero("1221212");
			conta.setSaldo(2);
			conta.setTitular(pessoa);

			System.out.println(conta);
			
			dao.save(conta);

			System.out.println(conta);
		} finally {
			dao.close();
		}
	}

}
