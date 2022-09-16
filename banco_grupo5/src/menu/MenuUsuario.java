package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import funcionario.Funcionario;
import funcionario.Gerente;
import pessoa.Pessoa;

public class MenuUsuario extends Menu {

	public String cargoUsuario;
	public String cpfUsuario;
	public ContaCorrente contaCorrenteUsuario;
	public ContaPoupanca contaPoupancaUsuario;

	Scanner in = new Scanner(System.in);

	public MenuUsuario(ArrayList<Conta> listaConta, String cpfUsuario) {
		super();
		this.listaConta = listaConta;
		this.cpfUsuario = cpfUsuario;
		for (int i = 0; i < listaConta.size(); i++) {
			if (cpfUsuario.equals(listaConta.get(i).getCpfTitular())) {
				if (listaConta.get(i).getTIPO().equals("CONTACORRENTE")) {
					contaCorrenteUsuario = (ContaCorrente) listaConta.get(i);
				} else if (listaConta.get(i).getTIPO().equals("CONTAPOUPANCA")) {
					contaPoupancaUsuario = (ContaPoupanca) listaConta.get(i);
				}

			}

		}

	}

	public MenuUsuario(ArrayList<Conta> listaConta, ArrayList<Cliente> listaCliente,
			ArrayList<Funcionario> listaFuncionario, String cpfUsuario, String cargoUsuario) {
		super();
		this.listaConta = listaConta;
		this.listaCliente = listaCliente;
		this.listaFuncionario = listaFuncionario;
		this.cpfUsuario = cpfUsuario;
		this.cargoUsuario = cargoUsuario;
		for (int i = 0; i < listaConta.size(); i++) {
			if (cpfUsuario.equals(listaConta.get(i).getCpfTitular())) {
				if (listaConta.get(i).getTIPO().equals("CONTACORRENTE")) {
					contaCorrenteUsuario = (ContaCorrente) listaConta.get(i);
				} else if (listaConta.get(i).getTIPO().equals("CONTAPOUPANCA")) {
					contaPoupancaUsuario = (ContaPoupanca) listaConta.get(i);
				}

			}

		}

	}

	public void menuCliente() {

		int opcao;

		do {
			System.out.println("Escolha uma opção:\n1 - Movimentações de conta.\n2 - Relatórios.\n3 - Sair.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:

				movimentacoesConta();
				break;

			case 2:
				if (cargoUsuario.equals("PRESIDENTE")) {
					relatoriosPresidente();
				} else if (cargoUsuario.equals("DIRETOR")) {
					relatoriosDiretor();
				} else if (cargoUsuario.equals("GERENTE")) {
					relatoriosGerente();
				} else {
					relatoriosCliente();
				}

				break;

			default:
				break;
			}

		} while (opcao != 3);

	}

	public void movimentacoesConta() {
		int opcao;
		do {
			System.out.println("Escolha uma opção:\n1 - Saque.\n2 - Depósito.\n3 - Transferência.\n4 - Voltar.");
			opcao = in.nextInt();
			double valor;
			switch (opcao) {

			case 1:
				System.out.println("Informe um valor para o saque:");
				valor = in.nextDouble();
				contaCorrenteUsuario.sacar(valor);
				break;

			case 2:
				System.out.println("Informe um valor para o depósito:");
				valor = in.nextDouble();
				contaCorrenteUsuario.depositar(valor);
				break;

			case 3:
				System.out.println("Informe o cpf do titular da conta destino:");
				String cpfTitular = in.next();
				Conta destino;

				for (int i = 0; i < listaConta.size(); i++) {

					if (cpfTitular.equals(listaConta.get(i).getCpfTitular())
							&& listaConta.get(i).getTIPO().equals("CONTACORRENTE")) {

						destino = listaConta.get(i);

						System.out.println("Informe o valor da transferencia:");
						valor = in.nextDouble();

						contaCorrenteUsuario.transferir(destino, valor);
						break;
					}
				}
			default:
				break;
			}

		} while (opcao != 4);
	}

	public void relatoriosCliente() {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:

				System.out.printf("Seu saldo atual é de: R$%.2f", contaCorrenteUsuario.getSaldo());
				break;

			case 2:

				contaCorrenteUsuario.relatorioTributacao();
				break;

			case 3:
				poupancaEntrada();
				break;

			default:
				break;
			}

		} while (opcao != 4);

	}

	public void relatoriosGerente() {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência. \n5 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:

				System.out.printf("Seu saldo atual é de: R$%.2f", contaCorrenteUsuario.getSaldo());
				break;

			case 2:

				contaCorrenteUsuario.relatorioTributacao();
				break;

			case 3:
				poupancaEntrada();
				break;

			case 4:
				relatorioNumContas();
				break;

			default:
				break;
			}

		} while (opcao != 5);

	}

	public void relatoriosDiretor() {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência."
					+ "\n5 - Relatório dos Clientes. \n6 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				System.out.printf("Seu saldo atual é de: R$%.2f", contaCorrenteUsuario.getSaldo());
				break;

			case 2:
				contaCorrenteUsuario.relatorioTributacao();
				break;

			case 3:
				poupancaEntrada();
				break;

			case 4:
				relatorioNumContas();
				break;

			case 5:
				relatorioInfoClientes();
				break;

			default:
				break;
			}

		} while (opcao != 6);

	}

	public void relatoriosPresidente() {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência."
					+ "\n5 - Relatório dos Clientes. " + "\n6 - Relatório Capital Total:." + "\n7 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				System.out.printf("Seu saldo atual é de: R$%.2f", contaCorrenteUsuario.getSaldo());
				break;

			case 2:
				contaCorrenteUsuario.relatorioTributacao();
				break;

			case 3:
				poupancaEntrada();
				break;

			case 4:
				relatorioNumContas();
				break;

			case 5:
				relatorioInfoClientes();
				break;

			case 6:
				relatorioCapitalTotal();
				break;

			default:
				break;
			}

		} while (opcao != 7);

	}

	public void poupancaEntrada() {
		System.out.println("Digite o valor para a simulação de rendimento da poupança");
		double valor = in.nextDouble();
		System.out.println("Digite a data final para a simulação no formato dd/MM/yyyy");
		String dataPlanejada = in.next();
		contaPoupancaUsuario.relatorioRendimento(valor, dataPlanejada);
	}

	public void relatorioNumContas() {
		int contadorContasAgencia = 0;
		String numeroAgencia = null;
		Gerente gerente;

		if (cargoUsuario.equals("GERENTE")) {
			for (int i = 0; i < listaFuncionario.size(); i++) {
				if (cpfUsuario.equals(listaFuncionario.get(i).getCpf())) {
					gerente = (Gerente) listaFuncionario.get(i);
					numeroAgencia = gerente.getIdAgencia();

				}
			}

		} else {
			System.out.println("Digite o número da agência desejado: ");
			numeroAgencia = in.next();
		}

		for (int i = 0; i < listaConta.size(); i++) {
			if (numeroAgencia.equals(listaConta.get(i).getIdAgencia())
					&& listaConta.get(i).getTIPO().equals("CONTACORRENTE")) {

				contadorContasAgencia++;
			}

		}
		System.out.println("A quantidade de contas nessa agência é de: " + contadorContasAgencia);

	}

	public void relatorioInfoClientes() {
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		for (int i = 0; i < listaCliente.size(); i++) {
			listaPessoa.add(listaCliente.get(i));

		}
		for (int i = 0; i < listaFuncionario.size(); i++) {
			// System.out.println(listaFuncionario.get(i).getNome());
			listaPessoa.add(listaFuncionario.get(i));

		}

		if (listaPessoa.size() > 0) {

			Collections.sort(listaPessoa, new Comparator<Pessoa>() {

				@Override
				public int compare(final Pessoa pessoa1, final Pessoa pessoa2) {
					return pessoa1.getNome().compareTo(pessoa2.getNome());
				}
			});
		}

		for (int i = 0; i < listaPessoa.size(); i++) {
			System.out.println(listaPessoa.get(i).toString());
			for (int j = 0; j < listaConta.size(); j++) {
				if (listaPessoa.get(i).getCpf().equals(listaConta.get(j).getCpfTitular())
						&& listaConta.get(j).getTIPO().equals("CONTACORRENTE")) {
					System.out.println("\tAgência Conta: " + listaConta.get(j).getIdAgencia() + "\n");
				}
			}
		}
	}

	public void relatorioCapitalTotal() {
		double total = 0;
		for (int i = 0; i < listaConta.size(); i++) {
			total += listaConta.get(i).getSaldo();
		}
		System.out.printf("Valor total do capital armazenado no banco: R$ %.2f\n", total);
	}

}
