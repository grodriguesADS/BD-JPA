package dac;

import java.util.List;
import java.util.Scanner;

import dao.PersistenciaDacException;
import dao.PessoaDao;
import entidades.Pessoa;

public class Funcoes {
	  
	private Scanner leitor = new Scanner(System.in);
	private PessoaDao dao = new PessoaDao();
	
	
	private boolean ExisteDado() throws DacException {
		List<Pessoa> usuarios = dao.getAll();
		if(usuarios.size() == 0) {
			return false;
		}
		return true;
	}
	public void GetAll()  throws DacException {
		
		try {			
			List<Pessoa> usuarios = dao.getAll();
			if(usuarios.size() == 0) {
				System.out.println("Sem cadastro");
			}else {
				for (Pessoa user : usuarios) {
					System.out.println("id: " + user.getId() + " | " + "CPF: " + user.getCPF() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
				}				
			}			

		} finally {
			
		}
	}
	
	public void Salvar() throws DacException {
				
		try {
			Pessoa user = new Pessoa();
			System.out.println("Nome:");
			user.setNome(leitor.nextLine());
			
			System.out.println("Sexo");
			user.setSexo(leitor.nextLine());
			
			System.out.println("CPF");
			user.setCPF(leitor.nextLine());

			System.out.println(user);
			
			dao.save(user);

			System.out.println(user);
		} finally {
			
		}
	}
	
	public void Deletar(int id) throws DacException {
		
		try {
			Pessoa user =new Pessoa();
			user = dao.getByID(id);
			dao.delete(user);

			System.out.println("Pessoa: " + user.getNome() + " " + "ID: " + user.getId() + " " + "Deletada");
		} finally {
			
		}
		}
	
	public void DeletarTodos()throws DacException {
		
		System.out.println("Para Confirmar a Exclução Dos Dados  Didite 'confirmar'");
		
		if(!leitor.nextLine().equals("contirmar")) {
			System.out.println("Processo Cancelado");
		}
		try {
			List<Pessoa> usuarios = dao.getAll();
			for (Pessoa usuario : usuarios) {
				dao.delete(usuario);
				System.out.println("Dados Excluidos....");
			}
		} finally {
			
		}
	}
	
	public void GetID () throws DacException {
		if(ExisteDado()== false) {
			System.out.println("Sistemas Sem Dados");
			
		}else {
			System.out.print("ID:");
			int id = Integer.parseInt(leitor.nextLine());
			
			try {	
				Pessoa user = dao.getByID(id);

				System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
			} finally {
				
			}
			
		}
		
	}
	
	public void Up(int id) throws DacException{
		
		try {	
			
			Pessoa user = dao.getByID(id);
			String sair = "n";
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
			
			while(!sair.equals("s")) {
				System.out.println("Qual Dado Deseja Atualizar"
						+ "\n 1- Nome"
						+ "\n 2- Sexo"
						+ "\n S- Sair");
				String op = leitor.nextLine();

				
				if(op.equals("1")) {
					System.out.println("Qual o Novo Nome:");
					user.setNome(leitor.nextLine());
				}
				else if(op.equals("2")) {
					System.out.println("Qual o Novo Sexo:");
					user.setSexo(leitor.nextLine());
					
				}else if(op.equals("s")) {
					System.out.println("Saindo....");
					sair = "s";
				}else {
					System.out.println("Opção Invalida");
				}
			}
			
			
			dao.update(user);
						

			System.out.println("--Dados Atualizados--");
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() + " | " + "sexo: " + user.getSexo());
		} finally {
			
		}
		
	}
	public void Fechar() {
		dao.close();
	}
		
	
}
