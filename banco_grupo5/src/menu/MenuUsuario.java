package menu;

import java.util.ArrayList;
import java.util.Scanner;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class MenuUsuario extends Menu {

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

	public void menuCliente() {
		System.out.println("Bem-vindo a área do Cliente!");

		int opcao;

		do {
			System.out.println("Escolha uma opção:\n1 - Movimentações de conta.\n2 - Relatórios.\n3 - Sair.");
			opcao = in.nextInt();

			switch (opcao) {
				case 1:

					movimentacoesConta();
					break;

				case 2:
					relatorios();
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
					System.out.println("Informe um valor para o saque");
					valor = in.nextDouble();
					contaCorrenteUsuario.sacar(valor);
					break;

				case 2:
					System.out.println("Informe um valor para o depósito");
					valor = in.nextDouble();
					contaCorrenteUsuario.depositar(valor);
					break;

				case 3:
					System.out.println("Informe o cpf do titular da conta destino");
					String cpfTitular = in.next();
					Conta destino;

					for (int i = 0; i < listaConta.size(); i++) {

						if (cpfTitular.equals(listaConta.get(i).getCpfTitular())
								&& listaConta.get(i).getTIPO().equals("CONTACORRENTE")) {

							destino = listaConta.get(i);

							System.out.println("Informe o valor da transferencia");
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

	public void relatorios() {

		int opcao;
do {
	System.out.println("Escolha uma opção:\n1 - Saldo.\n2 - Relatório de Tributação da Conta Corrente."+
		"\n3 - Relatório de Rendimento da Conta Poupança.\n4 - Voltar.");
		opcao = in.nextInt();
		
		switch (opcao) {
			case 1:
			
				System.out.println(contaCorrenteUsuario.getSaldo());
				break;
			
			case 2:

				contaCorrenteUsuario.relatorioTributacao();
				break;

			case 3:
				System.out.println("Digite o valor para a simulação de rendimento da poupança");
				double valor = in.nextDouble();
				System.out.println("Digite a data final para a simulação no formato dd/MM/yyyy");
				String dataPlanejada = in.next();
				contaPoupancaUsuario.relatorioRendimento(valor, dataPlanejada);
				break;
			default:
				break;
		}
	
} while (opcao!=4);
		


		
	}

}
