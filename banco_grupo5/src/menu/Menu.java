package menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import funcionario.Diretor;
import funcionario.Funcionario;
import funcionario.Gerente;
import funcionario.Presidente;

public class Menu {

	public ArrayList<Funcionario> listaFuncionario;
	public ArrayList<Cliente> listaCliente;
	public ArrayList<Conta> listaConta;

	public Menu() {
		super();
		listaFuncionario = new ArrayList();
		listaCliente = new ArrayList();
		listaConta = new ArrayList();
		
	}

	public void login() {

		Scanner in = new Scanner(System.in);

		listas();

//		for (int i = 0; i < listaCliente.size(); i++) {
//			System.out.println(listaCliente.get(i).getCpf());
//			System.out.println(listaCliente.get(i).getSenha());
//		}

		System.out.println("Login: ");
		String login = in.next();

		System.out.println("Senha: ");
		String senha = in.next();

		for (int i = 0; i < listaCliente.size(); i++) {

			if (login.equals(listaCliente.get(i).getCpf()) && senha.equals(listaCliente.get(i).getSenha())) {
				System.out.printf("Usuário logado com sucesso!");
				//menuUsuario(lista, login)
			}
		}

		for (int i = 0; i < listaFuncionario.size(); i++) {

			if (login.equals(listaFuncionario.get(i).getCpf()) && senha.equals(listaFuncionario.get(i).getSenha())) {
				System.out.printf("Usuário logado com sucesso!");
			}
		}

		System.out.println("Login ou senha inválidos.");

//verificar pessoa

	}

	public void menuCliente() {


	}

	public void listas() {
		
		ContaCorrente contaCorrente1 = new ContaCorrente("1", 4000.00, "1");
		ContaPoupanca contaPoupanca1 = new ContaPoupanca("1", 2000.00, "1");
		
		ContaCorrente contaCorrente2 = new ContaCorrente("2", 5000.00, "2");
		ContaPoupanca contaPoupanca2 = new ContaPoupanca("2", 5000.00, "2");

		ContaCorrente contaCorrente3 = new ContaCorrente("3", 5000.00, "3");
		ContaPoupanca contaPoupanca3 = new ContaPoupanca("3", 5000.00, "3");
		
		ContaCorrente contaCorrente4 = new ContaCorrente("4", 5000.00, "4");
		ContaPoupanca contaPoupanca4 = new ContaPoupanca("4", 5000.00, "4");
		
		ContaCorrente contaCorrente5 = new ContaCorrente("5", 5000.00, "5");
		ContaPoupanca contaPoupanca5 = new ContaPoupanca("5", 5000.00, "5");
		
		ContaCorrente contaCorrente6 = new ContaCorrente("6", 5000.00, "6");
		ContaPoupanca contaPoupanca6 = new ContaPoupanca("6", 5000.00, "6");
		
		Gerente gerente1 = new Gerente("1", "1", "1");
		Gerente gerente2 = new Gerente("2", "2", "2");
		Diretor diretor1 = new Diretor("3", "3");
		Presidente presidente = new Presidente("4", "4");

		Cliente cliente1 = new Cliente("5", "5");
		Cliente cliente2 = new Cliente("6", "6");
		
		listaConta.add(contaCorrente1);
		listaConta.add(contaPoupanca1);
		listaConta.add(contaCorrente2);
		listaConta.add(contaPoupanca2);
		listaConta.add(contaCorrente3);
		listaConta.add(contaPoupanca3);
		listaConta.add(contaCorrente4);
		listaConta.add(contaPoupanca4);
		listaConta.add(contaCorrente5);
		listaConta.add(contaPoupanca5);
		listaConta.add(contaCorrente6);
		listaConta.add(contaPoupanca6);
		
		listaFuncionario.add(gerente1);
		listaFuncionario.add(gerente2);
		listaFuncionario.add(diretor1);
		listaFuncionario.add(presidente);

		listaCliente.add(cliente1);
		listaCliente.add(cliente2);

	}
}
