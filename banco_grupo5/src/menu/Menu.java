package menu;
import java.util.ArrayList;
import java.util.Scanner;

import cliente.Cliente;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import funcionario.Diretor;
import funcionario.Funcionario;
import funcionario.Gerente;
import funcionario.Presidente;

public class Menu {
    
    public void login(){

        Scanner in = new Scanner (System.in);

        System.out.println("Login: ");
        String login = in.nextLine();

        System.out.println("Senha: ");
        String senha = in.nextLine();



        if(login=="" && senha==""){
        System.out.printf("Usuário %s logado com sucesso!", login);
    }else{
        System.out.println("Login ou senha inválidos.");
}

//verificar pessoa

    }


    public void menuCliente(){

        ContaPoupanca contaPoupanca1 = new ContaPoupanca("212323212",2000.00,"25");
        ContaCorrente contaCorrente1 = new ContaCorrente("00330223",4000.00,"26");
        ContaCorrente contaCorrente2 = new ContaCorrente("012939238", 5000.00, "28");

        contaPoupanca1.relatorioRendimento(100.00, 365);

        contaCorrente1.sacar(2000.00);
        contaCorrente1.sacar(500.00);
        contaCorrente1.transferir(contaCorrente2, 500.00);
        System.out.println(contaCorrente1.getSaldo());
        System.out.println(contaCorrente2.getSaldo());
        contaCorrente1.relatorioTributacao();

    }


    public void listas(){
        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        ArrayList<Cliente> listaCliente = new ArrayList();

        Gerente gerente1 = new Gerente("1", "1", "1");
        Gerente gerente2 = new Gerente("2", "2", "2");
        Gerente gerente3 = new Gerente("3", "3", "3");
        Diretor diretor1 = new Diretor("4", "4", "4");
        Diretor diretor2 = new Diretor("5", "5", "5");
        Presidente presidente = new Presidente("6","6");


        Cliente cliente1 = new Cliente("10","10");
        Cliente cliente2 = new Cliente("11","11");
        Cliente cliente3 = new Cliente("12","12");
        Cliente cliente4 = new Cliente("13","13");


    }
}
