package conta;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {
	private final String TIPO = "CONTAPOUPANCA";
	private final double PORCENTAGEMRENDIMENTO = 0.0165;

	public ContaPoupanca() {

	}

	public ContaPoupanca(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);

	}

	public void relatorioRendimento(double valor, int quantDias) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		double valor1 = valor + (valor * (quantDias * (PORCENTAGEMRENDIMENTO / 100)));
		System.out.println("Valor final será de: R$" + df.format(valor1));

	}

}