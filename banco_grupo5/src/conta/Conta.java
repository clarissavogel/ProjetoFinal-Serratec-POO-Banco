package conta;

public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private String idAgencia;
	private final String TIPO = "CONTA";
	

	public Conta() {
	}
	public Conta(String cpfTitular, double saldo, String idAgencia) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.idAgencia = idAgencia;
		
	
	}
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getTIPO() {
		return TIPO;
	}
	@Override
	public String toString() {
		return "Conta [cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", idAgencia=" + idAgencia + ", TIPO=" + TIPO
				+ "]";
	}
	
	
	

	
	
	
	
	
	
}
