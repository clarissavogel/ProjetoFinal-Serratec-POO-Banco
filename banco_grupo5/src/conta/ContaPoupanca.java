package conta;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
	private final String TIPO = "CONTAPOUPANCA";
	private final double PORCENTAGEMRENDIMENTO = 0.0165;//Porcentagem de rendimento diaria 

	public ContaPoupanca() {

	}

	public ContaPoupanca(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);

	}
	//Relatório de rendimento da conta poupança aonde o usuario entrará com o valor desejado e a data desejada, para o calculo
	//baseado em 6% anual
	public String relatorioRendimento(double valor, String dataPlanejada) {//data e valor planejado pelo usuario

		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFinal = LocalDate.parse(dataPlanejada, formatter);
		int dias = (int) ChronoUnit.DAYS.between(hoje, dataFinal);//conversão para o calculo da data em dias

		DecimalFormat df = new DecimalFormat("##0.00");
		double valor1 = valor + (valor * (dias * (PORCENTAGEMRENDIMENTO / 100)));
		System.out.println("Valor final será de: R$" + df.format(valor1));
		return "\nValor final será de: R$" + df.format(valor1) + " em" + dataFinal.format(formatter) + "\n";
	}

	@Override
	public String getTIPO() {
		return TIPO;
	}

}