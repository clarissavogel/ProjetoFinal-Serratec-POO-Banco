package pessoa;

public abstract class Pessoa {
	
	private String cpf;
	private String nome;
	private String senha;
	
	public Pessoa() {
		super();
		
	}
	
	
	public Pessoa(String cpf, String nome, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
	}


	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", senha=" + senha + "]";
	}

	
	
}
