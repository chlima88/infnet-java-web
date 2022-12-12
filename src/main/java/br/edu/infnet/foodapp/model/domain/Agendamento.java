package br.edu.infnet.foodapp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.foodapp.model.exceptions.DuracaoAtendimentoException;

public class Agendamento {
	
	private LocalDateTime data;
	private boolean confirmado;
	private int duracaoEmMinutos;
	private Cliente cliente;
	private List<Servico> servicos;
	
	
	public Agendamento() {
		this.data = LocalDateTime.now();
		this.duracaoEmMinutos = 0;
		this.servicos = new ArrayList<Servico>();
	}


	public int getDuracaoEmMinutos() {
		return this.duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) throws DuracaoAtendimentoException {
		if (duracaoEmMinutos <= 0 ) {
			throw new DuracaoAtendimentoException("A duracao do atendimento deve ser maior qur zero.");
		}
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public void adicionarServico(Servico servico) {
		this.servicos.add(servico);
	}
	
	public void removerServico(Servico servico) {
		int index = this.servicos.indexOf(servico);
		this.servicos.remove(index);
	}

	@Override
	public String toString() { 
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
		
		return String.format("%s;%d;%s", 
				this.data.format(dateFormat), 
				this.duracaoEmMinutos,
				this.confirmado ? "Sim" : "Não");
		
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
