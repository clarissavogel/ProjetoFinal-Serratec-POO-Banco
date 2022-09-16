package funcionario;

public class Gerente extends Funcionario {
	private String idAgencia;
	public final String CARGO = "GERENTE";

	public Gerente() {
		super();

	}

	public Gerente(String cpf, String nome, String senha, String idAgencia) {
		super(cpf, nome, senha);
		this.idAgencia = idAgencia;
	}

	public String getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	@Override
	public String getCARGO() {
		return CARGO;
	}

	@Override
	public String toString() {
		return "Gerente [idAgencia=" + idAgencia + ", CARGO=" + CARGO + ", getCpf()=" + getCpf() + ", getNome()="
				+ getNome() + "]";
	}

	
	
}
