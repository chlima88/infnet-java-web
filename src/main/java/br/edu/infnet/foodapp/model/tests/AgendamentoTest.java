package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Agendamento;
import br.edu.infnet.foodapp.model.domain.Cliente;
import br.edu.infnet.foodapp.model.domain.Lanternagem;
import br.edu.infnet.foodapp.model.domain.Mecanica;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class AgendamentoTest {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("cliente1","11111","1@cliente.com");
		Cliente c2 = new Cliente("cliente2","2222","2@cliente.com");
		
		Agendamento a1 = new Agendamento();
		a1.setConfirmado(false);
		a1.setDuracaoEmMinutos(120);
		a1.setCliente(c1);

		
		Agendamento a2 = new Agendamento();
		a2.setConfirmado(true);
		a2.setDuracaoEmMinutos(60);
		a2.setCliente(c2);
		
	
		Agendamento a3 = new Agendamento();
		a3.setConfirmado(true);
		a3.setDuracaoEmMinutos(60);
		a3.setCliente(c1);
		
		try {
			Mecanica m1 = new Mecanica("Alinhamento", "M01", 200, false);
			a1.setServicos(m1);
			a3.setServicos(m1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Mecanica m2 = new Mecanica("Troca de oleo", "M02", 150, true);
			m2.setCategoriaServico("revisao");
			m2.setProblemaMotor(false);
			a2.setServicos(m2);
			a3.setServicos(m2);

		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Lanternagem l2 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			l2.setLocalDanificado("Traseira");
			l2.setTamanhoAvaria("G");
			a3.setServicos(l2);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}		

		a1.imprimir();
		a2.imprimir();
		a3.imprimir();
	}

}
