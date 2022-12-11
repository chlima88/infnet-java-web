package br.edu.infnet.foodapp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Agendamento {
	
	private LocalDateTime data;
	private boolean confirmado;
	private int duracaoEmMinutos;
	private Cliente cliente;
	private List<Servico> servicos;
	
	
	public Agendamento() {
		this.data = LocalDateTime.now();
		this.duracaoEmMinutos = 0;
	}


	public int getDuracaoEmMinutos() {
		return this.duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServico() {
		return this.servicos;
	}

	public void setServico(List<Servico> servicos) {
		this.servicos = servicos;
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

	@Override
	public String toString() { 
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
		
		return String.format("%s;%s;%d;%s", 
				this.data.format(dateFormat), 
				this.cliente.getNome(),
				this.duracaoEmMinutos,
				this.confirmado ? "Sim" : "Não");
		
	}
}
