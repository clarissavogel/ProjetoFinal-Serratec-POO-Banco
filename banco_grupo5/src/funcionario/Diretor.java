package funcionario;

public class Diretor extends Gerente {

	public String CARGO = "DIRETOR";

	public Diretor() {
		super();
	}

	public Diretor(String cpf,String nome, String senha) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSenha(senha);

	}

	@Override
	public String getCARGO() {
		return CARGO;
	}


}
