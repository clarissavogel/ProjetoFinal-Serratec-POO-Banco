package funcionario;

public class Diretor extends Gerente {

	public String CARGO = "DIRETOR";

	public Diretor() {
		super();
	}

	public Diretor(String cpf, String nome, String senha) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSenha(senha);

	}

	@Override
	public String getCARGO() {
		return CARGO;
	}

	@Override
	public String toString() {
		return "Diretor [CARGO=" + CARGO + ", getIdAgencia()=" + getIdAgencia() + ", getCpf()=" + getCpf()
				+ ", getNome()=" + getNome() + "]";
	}



	/*
	 * Relatório com as informações de Nome, CPF e Agência de todos os clientes do
	 * sistema em ordem alfabética
	 */

}
