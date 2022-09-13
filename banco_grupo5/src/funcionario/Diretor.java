package funcionario;

public class Diretor extends Gerente {

	public String CARGO = "DIRETOR";

	public Diretor() {
		super();
	}

	public Diretor(String cpf, String senha) {
		this.setCpf(cpf);
		this.setSenha(senha);

	}

	public void relatorioInformacoesCliente() {

	}

	/*
	 * Relatório com as informações de Nome, CPF e Agência de todos os clientes do
	 * sistema em ordem alfabética
	 */

}
