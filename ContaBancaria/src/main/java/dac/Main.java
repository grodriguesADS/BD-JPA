package dac;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner leitor = new Scanner(System.in);
		
		Funcoes f = new Funcoes();
		String sair = "n";
		
		while(!sair.equals("s")) {
			System.out.println("--------Menu---------"
					+ "\n 1- Programa Conta"
					+ "\n 2- Programa Pessoa"
					
					+ "\n s- Sair");
			String op = leitor.nextLine();
			
			switch (op) {
				case "1":
					ProgramaConta conta = new ProgramaConta();
					break;
				case "2":
					ProgramaPessoa pessoa = new ProgramaPessoa();
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
