package conta;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
	private final String TIPO = "CONTAPOUPANCA";
	private final double PORCENTAGEMRENDIMENTO = 0.0165;

	public ContaPoupanca() {

	}

	public ContaPoupanca(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);

	}

	public String relatorioRendimento(double valor, String dataPlanejada) {

		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFinal = LocalDate.parse(dataPlanejada, formatter);
		int dias = (int) ChronoUnit.DAYS.between(hoje, dataFinal);

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		double valor1 = valor + (valor * (dias * (PORCENTAGEMRENDIMENTO / 100)));
		System.out.println("Valor final será de: R$" + df.format(valor1));
		return "\nValor final será de: R$" + df.format(valor1) + " em" + dataFinal.format(formatter) + "\n";
	}

	@Override
	public String getTIPO() {
		return TIPO;
	}

}