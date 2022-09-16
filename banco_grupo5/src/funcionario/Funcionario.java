package funcionario;

import java.io.Serializable;

import pessoa.Pessoa;

public abstract class Funcionario extends Pessoa implements Serializable {
	public final String CARGO = "FUNCIONARIO";

	public Funcionario(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		
	}

	public Funcionario() {
		super();
	}


	@Override
	public String toString() {
		return "Funcionario [CARGO=" + CARGO + ", getCpf()=" + getCpf() + ", getNome()=" + getNome() + ", getSenha()="
				+ getSenha() + "]";
	}

	public String getCARGO() {
		return CARGO;
	}

}
