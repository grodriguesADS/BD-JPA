package mainsConta;

import java.util.List;
import java.util.Scanner;

import dac.DacException;

import dao.ContaDao;
import dao.PessoaDao;
import entidades.ContaBancaria;
import entidades.Pessoa;

public class FuncaoConta {
	
	private Scanner leitor = new Scanner(System.in);
	private ContaDao dao = new ContaDao();
	
	
	private boolean ExisteDado() throws DacException {
		List<ContaBancaria> conta = dao.getAll();
		if(conta.size() == 0) {
			return false;
		}
		return true;
	}
	public void GetAll()  throws DacException {
		
		try {			
			List<ContaBancaria> conta = dao.getAll();
			if(conta.size() == 0) {
				System.out.println("Sem cadastro");
			}else {
				for (ContaBancaria user : conta) {
					System.out.println("id: " + user.getId() + " | " + "CPF: " + user.getCPF() + " | " + "numero: " + user.getNumero());
				}				
			}			

		} finally {
			
		}
	}
	
	public void Salvar() throws DacException {
				
		try {
			ContaBancaria conta = new ContaBancaria();
			System.out.println("CPF:");
			conta.setCPF(Integer.parseInt(leitor.nextLine()));
			
			System.out.println("Numero da Conta:");
			conta.setNumero(leitor.nextLine());
			
			System.out.println("Numero da Agencia:");
			conta.setAgencia(leitor.nextLine());
			

			
			PessoaDao user = new PessoaDao();
			System.out.println("Qual o ID da Pessoa dona da Conta");
			int id = Integer.parseInt(leitor.nextLine());
			Pessoa pessoa = user.getByID(id);
			
			conta.setTitular(pessoa);

			System.out.println(user);
			
			dao.save(conta);

			System.out.println(user);
		} finally {
			
		}
	}
	
	public void Deletar(int id) throws DacException {
		
		try {
			ContaBancaria conta =new ContaBancaria();
			conta = dao.getByID(id);
			dao.delete(conta);

			System.out.println("Conta do Cliente: " + conta.getTitular().getNome() + " " 
			+ "CPF: " + conta.getCPF() + " " + "Numero: " + conta.getNumero() + " " + "Deletada");
		} finally {
			
		}
		}
	
	public void DeletarTodos()throws DacException {
		
		System.out.println("Para Confirmar a Exclução Dos Dados  Didite 'confirmar'");
		
		if(!leitor.nextLine().equals("contirmar")) {
			System.out.println("Processo Cancelado");
		}
		try {
			List<ContaBancaria> conta = dao.getAll();
			for (ContaBancaria usuario : conta) {
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
				ContaBancaria conta = dao.getByID(id);

				System.out.println("Id da Conta: " + conta.getId() + " | " + "Nome do Cliente: " + conta.getTitular().getNome() 
						+ " | " + "Numero: " + conta.getNumero());
			} finally {
				
			}
			
		}
		
	}
	
	public void Up(int id) throws DacException{
		
		try {	
			
			ContaBancaria conta = dao.getByID(id);
			String sair = "n";
			System.out.println("ID: " + conta.getId() + " | " + "Numero da Conta: " 
			+ conta.getNumero() + " | " + "Agencia: " + conta.getAgencia() + " | " + "Saldo da Conta: " + conta.getSaldo());
			
			while(!sair.equals("s")) {
				System.out.println("Qual Dado Deseja Atualizar"
						+ "\n 1- ID"
						+ "\n 2- Numero da Conta"
						+ "\n 3- Numero da Agencia"
						+ "\n 4- Saldo"
						+ "\n S- Sair");
				String op = leitor.nextLine();

				
				if(op.equals("1")) {
					System.out.println("Qual o Novo ID:");
					conta.setId(Integer.parseInt(leitor.nextLine()));
				}else if(op.equals("2")) {
					System.out.println("Qual o Novo Numero da Conta:");
					conta.setNumero(leitor.nextLine());
					
				}else if(op.equals("3")) {
					System.out.println("Qual o Novo Numero da Agencia:");
					conta.setAgencia(leitor.nextLine());
					
				}else if(op.equals("4")) {
					System.out.println("Qual o Novo Saldo:");
					conta.setSaldo(Float.parseFloat(leitor.nextLine()));
					
				}else if(op.equals("s")) {
					System.out.println("Saindo....");
					sair = "s";
				}else {
					System.out.println("Opção Invalida");
				}
			}
			
			
			dao.update(conta);
						

			System.out.println("--Dados Atualizados--");
			System.out.println("ID: " + conta.getId() + " | " + "Numero da Conta: " 
					+ conta.getNumero() + " | " + "Agencia: " + conta.getAgencia() + " | " + "Saldo da Conta: " + conta.getSaldo());
		} finally {
			
		}
		
	}
	public void Fechar() {
		dao.close();
	}
		

}
