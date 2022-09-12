package conta;

public class ContaPoupanca extends Conta{
	private final String TIPO = "CONTAPOUPANCA";
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
		
	}
	
	public double relatorioRendimento() {
		return 0;
		
	}
		
	
}

