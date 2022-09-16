package conta;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Conta implements Serializable {
	private String cpfTitular;
	private double saldo;
	private String idAgencia;
	private final String TIPO = "CONTA";
	public final double TARIFA = 0.10;
	public final double TRANSFERIRTARIFA = 0.20;
	public int contadorSaque = 0;
	public int contadorDeposito = 0;
	public int contadorTransferencia = 0;{
	}

	public Conta() {
	}

	public Conta(String cpfTitular, double saldo, String idAgencia) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.idAgencia = idAgencia;
	}

	public String sacar(double valor) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		if (this.saldo > valor + TARIFA) {
			double novoSaldo = this.saldo - valor - TARIFA;
			this.saldo = novoSaldo;
			this.contadorSaque++;
			System.out.println("Saque realizado com sucesso!");
			return "===================="
					+ "\nSaque: "
					+ "\nValor Saque: "+ df.format(valor)
					+ "\nSaldo Anterior: "+ df.format(this.saldo + valor + TARIFA)
					+ "\nSaldo Atual: " + df.format(this.saldo)
					+ "====================";
		} else {
			System.out.println("Saque rejeitado!\nSaldo insuficiente para saque.");
			return null;
		}
	}

	// criar erro proposital.
	public String depositar(double deposito) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		if (deposito > TARIFA) {
			this.saldo = this.saldo + deposito - TARIFA;
			this.contadorDeposito++;
			System.out.println("Depósito realizado com sucesso!");
			return "===================="
			+ "\nDepósito: "
			+ "\nValor Depósito: "+df.format(deposito)
			+ "\nSaldo Anterior: "+ df.format(this.saldo - deposito + TARIFA)
			+ "\nSaldo Atual: " +df.format(this.saldo)
			+ "====================";
		} else {
			System.out.println("Deposito rejeitado!\nValor mínimo nescessário R$ 0,11.");
			return null;
		}
	}

	public String transferir(Conta destino, double valor) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		if (this.saldo >= valor + TRANSFERIRTARIFA) {
			this.saldo = this.saldo - valor - TRANSFERIRTARIFA;
			destino.saldo = destino.saldo + valor;
			this.contadorTransferencia++;
			System.out.println("Transferência realizada com sucesso!");
			return "===================="
			+ "\nTransferência: "
			+ "\nValor Transferência: "+df.format(valor)
			+ "\nConta Destino: "+destino.getCpfTitular()
			+ "\nSaldo Anterior: "+ df.format(this.saldo + valor + TRANSFERIRTARIFA)
			+ "\nSaldo Atual: " + df.format(this.saldo)
			+ "====================";
		} else {
			System.out.println("N�o h� saldo suficiente para transfer�ncia");
			return null;
		}
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
		return "\nConta do Cliente: " + cpfTitular + "\tSaldo: " + saldo + "\tAgência=" + idAgencia + "\tTIPO =" + TIPO;
	}

}
