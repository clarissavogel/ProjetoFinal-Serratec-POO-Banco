package funcionario;

import java.lang.reflect.Constructor;

public class Presidente extends Diretor {

	public final String CARGO = "PRESIDENTE";

	public Presidente() {
		super();
	}

	public Presidente(String cpf, String nome, String senha) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSenha(senha);
	}

	public void relatorioCapitalTotal() {
	}

	@Override
	public String toString() {
		return "Dados do Presidente: \n\tNome:" + getNome() + "\tCPF: " + getCpf();
	}

	@Override
	public String getCARGO() {
		return CARGO;
	}

}
