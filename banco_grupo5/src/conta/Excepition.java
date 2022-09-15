package conta;

public class Excepition extends RuntimeException {

	public void mostrarMensagem() {
		throw new IllegalArgumentException("Depósito indevido (Número Negativo).");
	}
}
