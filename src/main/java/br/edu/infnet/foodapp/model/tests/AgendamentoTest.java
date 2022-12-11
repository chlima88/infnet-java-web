package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Agendamento;
import br.edu.infnet.foodapp.model.domain.Cliente;

public class AgendamentoTest {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("cliente1","11111","1@cliente.com");

		Agendamento a1 = new Agendamento();
		a1.setConfirmado(false);
		a1.setDuracaoEmMinutos(120);
		a1.setCliente(c1);
		
		
		Cliente c2 = new Cliente("cliente2","2222","2@cliente.com");
		
		Agendamento a2 = new Agendamento();
		a2.setConfirmado(true);
		a2.setDuracaoEmMinutos(60);
		a2.setCliente(c2);
		
		
		System.out.println(a1);
		System.out.println(a2);
	}

}
