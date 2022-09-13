package funcionario;

public abstract class Funcionario {
	private String cpf;
	private String senha;
	public final String CARGO = "FUNCIONARIO";

	public Funcionario(String cpf, String senha) {
		super();
		this.cpf = cpf;
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

}
