package br.edu.infnet.foodapp.model.domain;

public class Cliente {

	private String nome;
	private String documento;
	private String contato;
	
	public Cliente(String nome, String documento, String contato) {
		this.nome = nome;
		this.documento = documento;
		this.contato = contato;
	}
	
	
	public String getNome() {
		return this.nome;
	}

	public String getDocumento() {
		return this.documento;
	}

	public String getContato() {
		return this.contato;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.documento);
		sb.append(";");
		sb.append(this.contato);
		
		return sb.toString();
	}
	
	
	
}
