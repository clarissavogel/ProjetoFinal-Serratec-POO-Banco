package funcionario;

public class Gerente extends Funcionario{
	private String idAgencia;
	public final String CARGO = "GERENTE";
	
	public String getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	

}
