package funcionario;

import java.lang.reflect.Constructor;

public class Presidente extends Diretor {

    public final String CARGO = "PRESIDENTE";

    public Presidente(String cpf, String senha, String idAgencia){
        super(cpf, senha, idAgencia);
    }

    public void relatorioCapitalTotal(){}


}
