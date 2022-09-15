package funcionario;

import java.io.Serializable;

public abstract class Funcionario implements Serializable{
	private String cpf;
	private String nome;
	private String senha;
	public final String CARGO = "FUNCIONARIO";

	public Funcionario(String cpf,String nome, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
	}

	public Funcionario() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCARGO() {
		return CARGO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
