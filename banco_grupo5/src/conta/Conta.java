package conta;

import java.io.Serializable;

public abstract class Conta implements Serializable  {
	private String cpfTitular;
	private double saldo;
	private String idAgencia;
	private final String TIPO = "CONTA";
	public final double TARIFA = 0.10;
	public final double TRANSFERIRTARIFA = 0.20;
	public int contadorSaque = 0;
	public int contadorDeposito = 0;
	public int contadorTransferencia = 0;

	public Conta() {
	}

	public Conta(String cpfTitular, double saldo, String idAgencia) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.idAgencia = idAgencia;
	}

	public void sacar(double valor) {
		if (this.saldo > valor + TARIFA) {
			double novoSaldo = this.saldo - valor - TARIFA;
			this.saldo = novoSaldo;
			this.contadorSaque++;
		} else {
			System.out.println("Saque rejeitado!\nSaldo insuficiente para saque.");
			;
		}
	}

	// criar erro proposital.
	public void depositar(double deposito) throws Excepition {
		try {
			if (deposito < 0) {
				throw new Excepition();
			}
		} catch (Excepition e) {
			e.mostrarMensagem();

		}

		if (deposito > TARIFA) {
			this.saldo = this.saldo + deposito - TARIFA;
			this.contadorDeposito++;
		} else {
			System.out.println("Deposito rejeitado!\nValor mínimo nescessário R$ 0,11.");
		}
	}

	public void transferir(Conta destino, double valor) {
		if (this.saldo >= valor + TRANSFERIRTARIFA) {
			this.saldo = this.saldo - valor - TRANSFERIRTARIFA;
			destino.saldo = destino.saldo + valor;
			this.contadorTransferencia++;
		} else {
			System.out.println("N�o h� saldo suficiente para transfer�ncia");
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
		return "Conta [cpfTitular=" + cpfTitular + ", saldo=" + saldo + ", idAgencia=" + idAgencia + ", TIPO=" + TIPO
				+ "]";
	}

}
