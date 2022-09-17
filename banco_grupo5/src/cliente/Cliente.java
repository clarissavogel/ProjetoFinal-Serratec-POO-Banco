package cliente;

import java.io.Serializable;

import pessoa.Pessoa;

//Classe herdando PESSOA com a finalidade de representar os clientes do banco com um construtor.

public class Cliente extends Pessoa implements Serializable {

	public Cliente(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
	}

	@Override
	public String toString() {
		return "Dados do Cliente:\n\tNome: " + getNome() + "\tCPF: " + getCpf();
	}

}
