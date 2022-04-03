package dac;

import java.util.Scanner;

import mainsConta.FuncaoConta;

public class ProgramaConta {
	
	public ProgramaConta() {

		Scanner leitor = new Scanner(System.in);
			
			FuncaoConta f = new FuncaoConta();
			String sair = "n";
			
			while(!sair.equals("s")) {
				System.out.println("--------Menu---------"
						+ "\n 1- Salvar Conta"
						+ "\n 2- Mostar Todas as Contas"
						+ "\n 3- Mostar Contas Pelo ID"
						+ "\n 4- Aatualizar Conta"
						+ "\n 5- Deletar Todos Os Dados"
						+ "\n s- Sair");
				String op = leitor.nextLine();
				
				switch (op) {
					case "1":
						try {
							f.Salvar();
						} catch (DacException e) {						
							e.printStackTrace();
						}
						break;
					case "2": 
						try {
							f.GetAll();
						} catch (DacException e) {						
							e.printStackTrace();
						}
						break;
					case "3": 
						try {
							
							f.GetID();
						} catch (DacException e) {						
							e.printStackTrace();
						}
						break;
					case "4":
						try {
							System.out.print("ID:");
							int id = Integer.parseInt(leitor.nextLine());
							f.Up(id);
						} catch (DacException e) {						
							e.printStackTrace();
						}
						break;
						
					case "5":
						System.out.println("Tem Certeza Que Deseja Excluir Todos Os Dados?"
								+"\n s - Sim"
								+"\n n - Não");
						if(leitor.nextLine().equals("n")) {
							break;
						}
						try {
							f.DeletarTodos();
						} catch (DacException e) {						
							e.printStackTrace();
						}
						break;
						
					case "s":
						f.Fechar();
						sair = "s";
						System.out.println("Programa Encerrado");
						break;
						
					default:
						System.out.println("Opção Invalida");
				}
			}
			
	
		}
	}



