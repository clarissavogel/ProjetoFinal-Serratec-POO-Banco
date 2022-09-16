package conta;

import java.text.DecimalFormat;

public class ContaCorrente extends Conta {

	private final String TIPO = "CONTACORRENTE";

	public ContaCorrente() {
	}

	public ContaCorrente(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
	}

	public String relatorioTributacao() {
		
		DecimalFormat df = new DecimalFormat("##0.00");
		String retorno = "====================\n"
		+"\nTributação:\nTotal Saques: R$"+ df.format(contadorSaque * TARIFA)
		+"\nValor únitario da tarifa: R$"+ df.format(TARIFA)
		+"\nTotal Depósitos: R$"+ df.format(contadorDeposito * TARIFA)
		+"\nValor únitario da tarifa: R$"+ df.format(TARIFA)
		+"\nTotal Transferências: R$"+ df.format(contadorTransferencia * TRANSFERIRTARIFA)
		+"\nValor únitario da tarifa: R$"+ df.format(TRANSFERIRTARIFA)
		+"\nValor total gasto: R$"
		+df.format((contadorSaque * TARIFA) + (contadorDeposito * TARIFA) + (contadorTransferencia * TRANSFERIRTARIFA))
		+"\n====================";
		System.out.println(retorno);

		return retorno;

	}

	@Override
	public String getTIPO() {
		return TIPO;
	}

}