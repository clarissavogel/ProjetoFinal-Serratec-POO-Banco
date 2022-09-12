
package conta;

public class ContaCorrente extends Conta{
	private final String TIPO = "CONTACORRENTE";
	
	public ContaCorrente() {		
	}

	public ContaCorrente(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
		
	}
	
	public void relatorioTributacao(){
		return 0;
		
	}
	
	
}
