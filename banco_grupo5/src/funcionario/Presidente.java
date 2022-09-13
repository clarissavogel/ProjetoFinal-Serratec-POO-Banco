package funcionario;

import java.lang.reflect.Constructor;

public class Presidente extends Diretor {

	public final String CARGO = "PRESIDENTE";

	public Presidente() {
		super();
	}

	public Presidente(String cpf, String senha) {
		super(cpf, senha);
		
	}

	public void relatorioCapitalTotal() {
	}

}
