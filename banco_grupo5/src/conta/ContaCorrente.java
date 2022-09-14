package conta;

public class ContaCorrente extends Conta {

private final String TIPO = "CONTACORRENTE";

	public ContaCorrente() {
	}

	public ContaCorrente(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
	}

	public void relatorioTributacao() {
		System.out.printf("\nTributação:\nTotal Saques: R$%.2f", contadorSaque * TARIFA);
		System.out.printf("\nValor únitario da tarifa: R$%.2f", TARIFA);
		System.out.printf("\nTotal Depósitos: R$%.2f", contadorDeposito * TARIFA);
		System.out.printf("\nValor únitario da tarifa: R$%.2f", TARIFA);
		System.out.printf("\nTotal Transferências: R$%.2f", contadorTransferencia * TRANSFERIRTARIFA);
		System.out.printf("\nValor únitario da tarifa: R$%.2f", TRANSFERIRTARIFA);
		System.out.printf("\nValor total gasto: R$%.2f",
				((contadorSaque * TARIFA) + (contadorDeposito * TARIFA) + (contadorTransferencia * TRANSFERIRTARIFA)));

	}

	@Override
	public String getTIPO() {
		return TIPO;
	}

	

}