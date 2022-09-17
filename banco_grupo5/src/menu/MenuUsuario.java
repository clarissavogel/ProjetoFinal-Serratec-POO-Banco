package menu;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
	public Comprovante comprovante = new Comprovante();
	public String comprovanteNome;
	public String comprovanteConteudo = "";

	public String getComprovanteConteudo() {
		return comprovanteConteudo;
	}

	public void setComprovanteConteudo(String comprovanteConteudo) {
		this.comprovanteConteudo += comprovanteConteudo;
	}

	public MenuUsuario(String comprovanteNome, ArrayList<Conta> listaConta, String cpfUsuario) {
		super();

		this.comprovanteNome = comprovanteNome;
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

	public MenuUsuario(String comprovanteNome, ArrayList<Conta> listaConta, ArrayList<Cliente> listaCliente,
			ArrayList<Funcionario> listaFuncionario, String cpfUsuario, String cargoUsuario) {
		super();
		this.comprovanteNome = comprovanteNome;
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

	public void menuCliente() throws FileNotFoundException {

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

				case 3:
					comprovante.printarComprovante(getComprovanteConteudo(), comprovanteNome);
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
					setComprovanteConteudo(contaCorrenteUsuario.sacar(valor));
					System.out.println(getComprovanteConteudo());
					break;

				case 2:
					System.out.println("Informe um valor para o depósito:");
					valor = in.nextDouble();
					setComprovanteConteudo(contaCorrenteUsuario.depositar(valor));
					System.out.println(getComprovanteConteudo());
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

							setComprovanteConteudo(contaCorrenteUsuario.transferir(destino, valor));
							System.out.println(getComprovanteConteudo());
							break;
						}
					}
				default:
					break;
			}

		} while (opcao != 4);
	}

	public void relatoriosCliente() throws FileNotFoundException {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				DecimalFormat df = new DecimalFormat("##0.00");
				System.out.println("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()));
				comprovante.printarComprovante("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()), comprovanteNome+"RelatorioSaldo");
				break;

			case 2:
				comprovante.printarComprovante(contaCorrenteUsuario.relatorioTributacao(), comprovanteNome+"RelatorioTributacao");
				
				break;

			case 3:
				comprovante.printarComprovante(poupancaEntrada(), comprovanteNome+"RelatorioPoupanca");
				break;

				default:
					break;
			}

		} while (opcao != 4);

	}

	public void relatoriosGerente() throws FileNotFoundException {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência. \n5 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				DecimalFormat df = new DecimalFormat("##0.00");
				System.out.println("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()));
				comprovante.printarComprovante("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()), comprovanteNome+"RelatorioSaldo");
				break;

			case 2:
				comprovante.printarComprovante(contaCorrenteUsuario.relatorioTributacao(), comprovanteNome+"RelatorioTributacao");
				
				break;

			case 3:
				comprovante.printarComprovante(poupancaEntrada(), comprovanteNome+"RelatorioPoupanca");
				break;

			case 4:
				comprovante.printarComprovante(relatorioNumContas(), comprovanteNome + "RelatorioNumContas");
				break;

				default:
					break;
			}

		} while (opcao != 5);

	}

	public void relatoriosDiretor() throws FileNotFoundException {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência."
					+ "\n5 - Relatório dos Clientes. \n6 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				DecimalFormat df = new DecimalFormat("##0.00");
				System.out.println("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()));
				comprovante.printarComprovante("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()), comprovanteNome+"RelatorioSaldo");
				break;

			case 2:
				comprovante.printarComprovante(contaCorrenteUsuario.relatorioTributacao(), comprovanteNome+"RelatorioTributacao");
				
				break;

			case 3:
				comprovante.printarComprovante(poupancaEntrada(), comprovanteNome+"RelatorioPoupanca");
				break;

			case 4:
				comprovante.printarComprovante(relatorioNumContas(), comprovanteNome + "RelatorioNumContas");
				break;

			case 5:
				comprovante.printarComprovante(relatorioInfoClientes(), comprovanteNome + "RelatorioInfoClientes");
				break;

				default:
					break;
			}

		} while (opcao != 6);

	}

	public void relatoriosPresidente() throws FileNotFoundException {

		int opcao;
		do {
			System.out.println("\nEscolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."
					+ "\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Relatório de total de contas da agência."
					+ "\n5 - Relatório dos Clientes. " + "\n6 - Relatório Capital Total:." + "\n7 - Voltar.");
			opcao = in.nextInt();

			switch (opcao) {
				case 1:
					DecimalFormat df = new DecimalFormat("##0.00");
					System.out.println("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()));
					comprovante.printarComprovante("Seu saldo atual é de: R$" + df.format(contaCorrenteUsuario.getSaldo()), comprovanteNome+"RelatorioSaldo");
					break;

				case 2:
					comprovante.printarComprovante(contaCorrenteUsuario.relatorioTributacao(), comprovanteNome+"RelatorioTributacao");
					
					break;

				case 3:
					comprovante.printarComprovante(poupancaEntrada(), comprovanteNome+"RelatorioPoupanca");
					break;

				case 4:
					comprovante.printarComprovante(relatorioNumContas(), comprovanteNome + "RelatorioNumContas");
					break;

				case 5:
					comprovante.printarComprovante(relatorioInfoClientes(), comprovanteNome + "RelatorioInfoClientes");
					break;

				case 6:
					comprovante.printarComprovante(relatorioCapitalTotal(), comprovanteNome + "RelatorioCapital");
					break;

				default:
					break;
			}

		} while (opcao != 7);

	}

	public String poupancaEntrada() {
		String retorno= "===================";
		System.out.println("Digite o valor para a simulação de rendimento da poupança");
		double valor = in.nextDouble();
		System.out.println("Digite a data final para a simulação no formato dd/MM/yyyy");
		String dataPlanejada = in.next();
		retorno += contaPoupancaUsuario.relatorioRendimento(valor, dataPlanejada);
		return retorno
		+"\n====================";
	}

	public String relatorioNumContas() {
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
		return "====================\n"
				+ "Existem " + contadorContasAgencia + " contas na Agencia " + numeroAgencia
				+ "\n===================";

	}

	public String relatorioInfoClientes() {
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		String retorno = "====================\n";

		for (int i = 0; i < listaCliente.size(); i++) {
			listaPessoa.add(listaCliente.get(i));

		}
		for (int i = 0; i < listaFuncionario.size(); i++) {
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
			retorno += listaPessoa.get(i).toString();

			for (int j = 0; j < listaConta.size(); j++) {
				if (listaPessoa.get(i).getCpf().equals(listaConta.get(j).getCpfTitular())
						&& listaConta.get(j).getTIPO().equals("CONTACORRENTE")) {
					System.out.println("\tAgência Conta: " + listaConta.get(j).getIdAgencia() + "\n");
					retorno += "\n\tAgência Conta: " + listaConta.get(j).getIdAgencia() + "\n\n";

				}
			}
			retorno += "====================\n";
		}
		return retorno;
	}

	public String relatorioCapitalTotal() {
		double total = 0;
		DecimalFormat df = new DecimalFormat("##0.00");
		for (int i = 0; i < listaConta.size(); i++) {
			total += listaConta.get(i).getSaldo();
		}
		System.out.printf("Valor total do capital armazenado no banco: R$ %.2f\n", total);
		return "===================\n"
				+ "Relatório de Capital do Banco\n"
				+ "Valor total do capital armazenado no banco: R$" + df.format(total)
				+ "\n===================";
	}

}
