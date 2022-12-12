package br.edu.infnet.atapp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.atapp.model.exceptions.ClienteIndefinidoException;
import br.edu.infnet.atapp.model.exceptions.DuracaoAtendimentoException;
import br.edu.infnet.atapp.model.exceptions.ServicoIndefinidoException;

public class Agendamento {
	
	private LocalDateTime data;
	private boolean confirmado;
	private int duracaoEmMinutos;
	private Cliente cliente;
	private List<Servico> servicos;
	
	
	public Agendamento(Cliente cliente, List<Servico> servicos) throws ClienteIndefinidoException, ServicoIndefinidoException {
		
		if (cliente == null) {
			throw new ClienteIndefinidoException("E necessário atribuir um cliente ao agendamento");	
		}
		
		if (servicos == null) {
			throw new ServicoIndefinidoException("E necessario atribuir um servico ao agendamento");
		}
		
		this.data = LocalDateTime.now();
		this.duracaoEmMinutos = 0;
		this.cliente = cliente;
		this.servicos = servicos;
	}


	public int getDuracaoEmMinutos() {
		return this.duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) throws DuracaoAtendimentoException {
		if (duracaoEmMinutos <= 0 ) {
			throw new DuracaoAtendimentoException("A duracao do atendimento deve ser maior que zero.");
		}
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public LocalDateTime getData() {
		return this.data;
	}	
	
	public boolean getConfirmado() {
		return this.confirmado;
	}
	
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	public List<Servico> getServicos() {
		return this.servicos;
	}


	@Override
	public String toString() { 
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
		
		return String.format("%s;%d;%s", 
				this.data.format(dateFormat), 
				this.duracaoEmMinutos,
				this.confirmado ? "Sim" : "Não");
		
	}
	
	public String obterPedido() {
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
		
		StringBuilder sb = new StringBuilder();
		
		
		float orcamento = 0;
		for (Servico servico: this.servicos) {
			orcamento += servico.obterPrecoFinal();
		}
		
		sb.append(this.data.format(dateFormat));
		sb.append(";");
		sb.append(this.duracaoEmMinutos);
		sb.append(";");
		sb.append(this.confirmado ? "Sim" : "Não");
		sb.append(";");
		sb.append(this.cliente);
		sb.append(";");
		sb.append(this.servicos.size());
		sb.append(";");
		sb.append(orcamento);
		sb.append("\r\n");
		
		return sb.toString(); 
	}
	
	public void imprimir() {

		System.out.println("");
		System.out.println("Cliente: " + this.cliente);
		System.out.println("Agendamento: " + this.toString());
		System.out.println("Qtd. Servicos: " + this.servicos.size());
		System.out.println("Servicos: ");
		
		for (Servico servico: this.servicos ) {
			System.out.println("   - " + servico.getNome() );
		}
	}
}
