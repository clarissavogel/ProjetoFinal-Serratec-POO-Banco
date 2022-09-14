package menu;

import java.util.ArrayList;
import java.util.Scanner;
import conta.Conta;

public class MenuUsuario extends Menu{
	
	public String cpfUsuario;
	
	Scanner in = new Scanner(System.in);
		
	
	public MenuUsuario(ArrayList<Conta> listaConta, String cpfUsuario) {
		super();
		this.listaConta = listaConta;
		this.cpfUsuario = cpfUsuario;

	}
	
	public void movimentacoesConta() {
			int opcao; 
		
		do {
			System.out.println("Escolha uma opção:\n1 - Saque.\n2 - Depósito.\n3 - Transferência.\n4 - Voltar.");
			opcao = in.nextInt();
			
		switch (opcao) {
		case 1:
			
			break;

		default:
			break;
		}
		
		} while (opcao!=4);
	}
	
	public void menuCliente() {
		System.out.println("Bem-vindo a área do Cliente!");
		
		int opcao; 
		
		do {
			System.out.println("Escolha uma opção:\n1 - Movimentações de conta.\n2 - Relatórios.\n3 - Sair.");
			opcao = in.nextInt();
			
		switch (opcao) {
		case 1:
			
			break;

		default:
			break;
		}
		
		} while (opcao!=3);
		
	}

}
