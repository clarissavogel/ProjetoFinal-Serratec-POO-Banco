package cliente;

import java.io.Serializable;

public class Cliente implements Serializable {
	private String cpf;
	private String nome;
	private String senha;
	
	public Cliente(String cpf, String nome, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
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
	
	@Override
	public String toString() {
		return "Cliente: " + nome + "\nCPF: " + cpf ;
	}
	
}
