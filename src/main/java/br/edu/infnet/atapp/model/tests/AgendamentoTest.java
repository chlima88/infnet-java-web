package br.edu.infnet.atapp.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.atapp.model.domain.Agendamento;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.exceptions.CategoriaInvalidaException;
import br.edu.infnet.atapp.model.exceptions.CircuitoInvalidoException;
import br.edu.infnet.atapp.model.exceptions.ClienteIndefinidoException;
import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.atapp.model.exceptions.DuracaoAtendimentoException;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;
import br.edu.infnet.atapp.model.exceptions.ServicoIndefinidoException;
import br.edu.infnet.atapp.model.exceptions.TamanhoInvalidoException;

public class AgendamentoTest {

	public static void main(String[] args) {	
		 		
		try {			
			System.out.println("\r\nTest case 1: Instanciar agendamento com sucesso\r\n");
		
			Cliente cliente = new Cliente("cliente1","11111","1@cliente.com");
			
			Mecanica servico1 = new Mecanica("Alinhamento", "M01", 200, false);
			servico1.setCategoriaServico("manutencao");
			servico1.setProblemaMotor(false);
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);		
			
			Agendamento agendamento = new Agendamento(cliente, servicos);
			agendamento.setConfirmado(false);
			agendamento.setDuracaoEmMinutos(120);
			agendamento.imprimir();
			
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException 
				| CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		} 
		
		
		try {
			System.out.println("\r\nTest case 2: Suporte a um ou multiplos servicos\r\n");
			
			Cliente cliente = new Cliente("cliente2","2222","2@cliente.com");

			Mecanica servico1 = new Mecanica("Troca de oleo", "M02", 150, true);
			servico1.setCategoriaServico("revisao");
			servico1.setProblemaMotor(false);
			
			Eletrica servico2 = new Eletrica("Reparo circuito luzes", "L02", 350, true);
			servico2.setCircuitoDanificado("luzes");
			servico2.setIncendio(false);
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);
			servicos.add(servico2);
			
			Agendamento agendamento = new Agendamento(cliente, servicos);
			agendamento.setConfirmado(true);
			agendamento.setDuracaoEmMinutos(60);	
			agendamento.imprimir();
			
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException 
				| CircuitoInvalidoException 
				| CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		
		try {
			System.out.println("\r\nTest case 3: Não permitir duracaoEmMinutos menor que zero\r\n");
			
			Cliente cliente = new Cliente("cliente3","3333","3@cliente.com");
			
			Lanternagem servico1 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			servico1.setLocalDanificado("Traseira");
			servico1.setTamanhoAvaria("G");
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);
			
			Agendamento agendamento = new Agendamento(cliente, servicos);
			agendamento.setConfirmado(true);
			agendamento.setDuracaoEmMinutos(-1);
			agendamento.imprimir();
					
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		} 
		
		
		
		try {
			System.out.println("\r\nTest case 4: Não permitir duracaoEmMinutos igual a zero\r\n");
			
			Cliente cliente = new Cliente("cliente3","3333","3@cliente.com");
			
			Mecanica servico1 = new Mecanica("Substituicao bloco motor","L03",800, false);
			servico1.setCategoriaServico("manutencao");
			servico1.setProblemaMotor(true);
			
			Lanternagem servico2 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			servico2.setLocalDanificado("Traseira");
			servico2.setTamanhoAvaria("G");
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);
			servicos.add(servico2);
			
			Agendamento agendamento = new Agendamento(cliente, servicos);
			agendamento.setConfirmado(true);
			agendamento.setDuracaoEmMinutos(0);
			agendamento.imprimir();
			
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException 
				| TamanhoInvalidoException
				| CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		} 
		
		try {
			System.out.println("\r\nTest case 5: Não permitir instanciar sem informar cliente\r\n");
			
			Cliente cliente = new Cliente("cliente3","3333","3@cliente.com");
			
			Mecanica servico1 = new Mecanica("Substituicao bloco motor","L03",800, false);
			servico1.setCategoriaServico("manutencao");
			servico1.setProblemaMotor(true);
			
			Lanternagem servico2 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			servico2.setLocalDanificado("Traseira");
			servico2.setTamanhoAvaria("G");
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);
			servicos.add(servico2);
			
			Agendamento agendamento = new Agendamento(null, servicos);
			agendamento.setConfirmado(true);
			agendamento.setDuracaoEmMinutos(60);
			
			agendamento.imprimir();
			
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException 
				| TamanhoInvalidoException
				| CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		
		try {
			System.out.println("\r\nTest case 6: Não permitir instanciar sem informar servicos\r\n");
			
			Cliente cliente = new Cliente("cliente3","3333","3@cliente.com");
			
			Mecanica servico1 = new Mecanica("Substituicao bloco motor","L03",800, false);
			servico1.setCategoriaServico("manutencao");
			servico1.setProblemaMotor(true);
			
			Lanternagem servico2 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			servico2.setLocalDanificado("Traseira");
			servico2.setTamanhoAvaria("G");
			
			List<Servico> servicos = new ArrayList<Servico>();
			servicos.add(servico1);
			servicos.add(servico2);
			
			Agendamento agendamento = new Agendamento(cliente, null);
			agendamento.setConfirmado(true);
			agendamento.setDuracaoEmMinutos(60);
			agendamento.imprimir();
			
		} catch (DuracaoAtendimentoException 
				| ClienteIndefinidoException 
				| ServicoIndefinidoException error) {
			System.out.println("Agendamento: " + error.getMessage());
		} catch (ClienteInvalidoException error) {
			System.out.println("Cliente: " + error.getMessage());
		} catch (PrecoBaseInvalidoException 
				| TamanhoInvalidoException
				| CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		} 
	}

}
