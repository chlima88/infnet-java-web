package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("\r\nTest case 1: Instanciar cliente com sucesso\r\n"
					+ "Saida Esperada: classe instanciada\r\n");
			Cliente c1 = new Cliente("cliente1", "111111", "c1@cliente.com");
			System.out.println(c1);
		} catch (ClienteInvalidoException error ) {
			System.out.println("Cliente: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 2: Instanciar cliente sem documento\r\n"
					+ "Saida Esperada: Mensagem de erro\r\n");
			Cliente c2 = new Cliente("cliente2", null, "c2@cliente.com");
			System.out.println(c2);
		} catch (ClienteInvalidoException error ) {
			System.out.println("Cliente: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 3: Instanciar cliente sem contato\r\n"
					+ "Saida Esperada: Mensagem de erro\r\n");
			Cliente c3 = new Cliente("cliente3", "111111", "");
			System.out.println(c3);
		} catch (ClienteInvalidoException error ) {
			System.out.println("Cliente: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 4: Instanciar cliente sem nome\r\n"
					+ "Saida Esperada: Mensagem de erro\r\n");
			Cliente c4 = new Cliente("", "111111", "c4@cliente.com");
			System.out.println(c4);
		} catch (ClienteInvalidoException error ) {
			System.out.println("Cliente: " + error.getMessage());
		}

	}

}
