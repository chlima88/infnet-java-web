package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Cliente;

public class ClienteTest {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("cliente1", "111111", "c1@cliente.com");
		System.out.println(c1);
		
		Cliente c2 = new Cliente("cliente1", "111111", "c1@cliente.com");
		System.out.println(c2);
		
		Cliente c3 = new Cliente("cliente1", "111111", "c1@cliente.com");
		System.out.println(c3);

	}

}
