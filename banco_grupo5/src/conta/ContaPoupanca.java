package conta;

public class ContaPoupanca extends Conta{
	private final String TIPO = "CONTAPOUPANCA";
	private final double PORCENTAGEMRENDIMENTO = 0.0165;
	
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(String cpfTitular, double saldo, String idAgencia) {
		super(cpfTitular, saldo, idAgencia);
		
	}
	
	public void relatorioRendimento(double valor, int quantDias) {
		System.out.println("Valor final será de: R$ "+ valor * (quantDias * (1 + PORCENTAGEMRENDIMENTO/100))) ;
		
		}
		

	
}

