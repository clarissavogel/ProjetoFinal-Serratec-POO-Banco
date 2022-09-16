package cliente;

import java.io.Serializable;

import pessoa.Pessoa;

public class Cliente extends Pessoa implements Serializable {

	public Cliente(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
	}

	@Override
	public String toString() {
		return "Dados do Cliente:\n\tNome: " + getNome() + "\tCPF: " + getCpf();
	}

}
