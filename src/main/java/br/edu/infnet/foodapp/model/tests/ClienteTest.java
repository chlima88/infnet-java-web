package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Cliente;
import br.edu.infnet.foodapp.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {
		
		try {
			Cliente c1 = new Cliente("clie", "111111", "c1@cliente.com");
			System.out.println(c1);
		} catch (ClienteInvalidoException error ) {
			System.out.println("C1: " + error.getMessage());
		}
		
		try {
			Cliente c2 = new Cliente("cliente2", null, "c2@cliente.com");
			System.out.println(c2);
		} catch (ClienteInvalidoException error ) {
			System.out.println("C2: " + error.getMessage());
		}
		
		try {
			Cliente c3 = new Cliente("cliente3", "111111", "");
			System.out.println(c3);
		} catch (ClienteInvalidoException error ) {
			System.out.println("C3: " + error.getMessage());
		}
		
		try {
			Cliente c4 = new Cliente("", "111111", "c4@cliente.com");
			System.out.println(c4);
		} catch (ClienteInvalidoException error ) {
			System.out.println("C4: " + error.getMessage());
		}

	}

}
