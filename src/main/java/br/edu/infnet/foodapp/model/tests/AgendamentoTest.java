package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Agendamento;
import br.edu.infnet.foodapp.model.domain.Cliente;
import br.edu.infnet.foodapp.model.domain.Eletrica;
import br.edu.infnet.foodapp.model.domain.Lanternagem;
import br.edu.infnet.foodapp.model.domain.Mecanica;
import br.edu.infnet.foodapp.model.exceptions.CategoriaInvalidaException;
import br.edu.infnet.foodapp.model.exceptions.CircuitoInvalidoException;
import br.edu.infnet.foodapp.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.foodapp.model.exceptions.DuracaoAtendimentoException;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;
import br.edu.infnet.foodapp.model.exceptions.TamanhoInvalidoException;

public class AgendamentoTest {

	public static void main(String[] args) {
		
		// Casos de teste
		// 1 - duracaoEmMinutos menor ou igual a zero
		// 2 - suporte a um ou multiplos servicos
		
		Agendamento a1 = new Agendamento();
		a1.setConfirmado(false);
		try {
			a1.setDuracaoEmMinutos(120);			
		} catch (DuracaoAtendimentoException error) {
			System.out.println("A1: " + error.getMessage());
		}
		
		Agendamento a2 = new Agendamento();
		a2.setConfirmado(true);
		try {
			a2.setDuracaoEmMinutos(60);			
		} catch (DuracaoAtendimentoException error) {
			System.out.println("A2: " + error.getMessage());
		}
		
		Agendamento a3 = new Agendamento();
		a3.setConfirmado(true);
		try {
			a3.setDuracaoEmMinutos(60);	
		} catch (DuracaoAtendimentoException error) {
			System.out.println("A3: " + error.getMessage());
		}			
		
		
		try {
			Cliente c1 = new Cliente("cliente1","11111","1@cliente.com");
			a1.setCliente(c1);
			a3.setCliente(c1);
			Cliente c2 = new Cliente("cliente2","2222","2@cliente.com");
			a2.setCliente(c2);
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		}
		
		
		try {
			Mecanica m1 = new Mecanica("Alinhamento", "M01", 200, false);
			m1.setCategoriaServico("manutencao");
			m1.setProblemaMotor(false);
			a1.adicionarServico(m1);
			a3.adicionarServico(m1);
		} catch (PrecoBaseInvalidoException | CategoriaInvalidaException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Eletrica e1 = new Eletrica("Reparo circuito luzes", "L02", 350, true);
			e1.setCircuitoDanificado("luzes");
			e1.setIncendio(false);
			a2.adicionarServico(e1);
			a3.adicionarServico(e1);
		} catch (PrecoBaseInvalidoException | CircuitoInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Lanternagem l1 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			l1.setLocalDanificado("Traseira");
			l1.setTamanhoAvaria("G");
			a3.adicionarServico(l1);
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println(error.getMessage());
		}		

		a1.imprimir();
		a2.imprimir();
		a3.imprimir();
	}

}
