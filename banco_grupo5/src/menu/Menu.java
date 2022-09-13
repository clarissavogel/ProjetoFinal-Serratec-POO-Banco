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

	public Menu() {
		super();
		listaFuncionario = new ArrayList();
		listaCliente = new ArrayList();
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

		ContaPoupanca contaPoupanca1 = new ContaPoupanca("212323212", 2000.00, "25");
		ContaCorrente contaCorrente1 = new ContaCorrente("00330223", 4000.00, "26");
		ContaCorrente contaCorrente2 = new ContaCorrente("012939238", 5000.00, "28");

		contaPoupanca1.relatorioRendimento(100.00, 365);

		contaCorrente1.sacar(1000.00);
		contaCorrente1.sacar(1000.00);
		contaCorrente1.depositar(1000.00);
		contaCorrente1.transferir(contaCorrente2, 1000.00);
		System.out.println("Saldo ContaCorrente1:" + contaCorrente1.getSaldo());
		System.out.println("Saldo ContaCorrente 2: " + contaCorrente2.getSaldo());
//		contaCorrente1.relatorioTributacao();

	}

	public void listas() {

		Gerente gerente1 = new Gerente("1", "1", "1");
		Gerente gerente2 = new Gerente("2", "2", "2");
		Gerente gerente3 = new Gerente("3", "3", "3");
		Diretor diretor1 = new Diretor("4", "4");
		Diretor diretor2 = new Diretor("5", "5");
		Presidente presidente = new Presidente("6", "6");

		Cliente cliente1 = new Cliente("10", "10");
		Cliente cliente2 = new Cliente("11", "11");
		Cliente cliente3 = new Cliente("12", "12");
		Cliente cliente4 = new Cliente("13", "13");

		listaFuncionario.add(gerente1);
		listaFuncionario.add(gerente2);
		listaFuncionario.add(gerente3);
		listaFuncionario.add(diretor1);
		listaFuncionario.add(diretor2);
		listaFuncionario.add(presidente);

		listaCliente.add(cliente1);
		listaCliente.add(cliente2);
		listaCliente.add(cliente3);
		listaCliente.add(cliente4);

	}
}
