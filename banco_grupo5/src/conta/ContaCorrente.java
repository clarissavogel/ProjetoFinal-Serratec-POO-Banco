
package conta;

public class ContaCorrente extends Conta{
	private final String TIPO = "CONTACORRENTE";
	
	public ContaCorrente() {				
	}

	public ContaCorrente(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
	}
	public void relatorioTributacao() {		
		System.out.printf("\nTributação:\nTotal Saques: R$%.2f%n"+contadorSaque * TARIFA +
				"\nValor únitario da tarifa: R$%.2f%n"+TARIFA+
				"\nTotal Depósitos: R$%.2f%n"+contadorDeposito * TARIFA+
				"\nValor únitario da tarifa: R$%.2f%n"+TARIFA+
				"\nTotal Transferências: R$%.2f%n"+contadorTransferencia * TRANSFERIRTARIFA +
				"\nValor únitario da tarifa: R$%.2f%n"+TRANSFERIRTARIFA);
		System.out.printf("\nValor total gasto: R$%.2f%n"+ ((contadorSaque * TARIFA)+(contadorDeposito * TARIFA)+(contadorTransferencia * TRANSFERIRTARIFA)));
			
	}
	
	
	
	
}
