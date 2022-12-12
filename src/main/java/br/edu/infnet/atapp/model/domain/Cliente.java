package br.edu.infnet.atapp.model.domain;

import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;

public class Cliente {

	private String nome;
	private String documento;
	private String contato;
	
	public Cliente(String nome, String documento, String contato) throws ClienteInvalidoException {
		
		if ( nome == "" || nome == null ) {
			throw new ClienteInvalidoException("O nome do cliente deve ser informado.");
		}
		if ( contato == "" || contato == null ) {
			throw new ClienteInvalidoException("O contato do cliente deve ser informado.");
		}
		if ( documento == "" || documento == null) {
			throw new ClienteInvalidoException("O documento do cliente deve ser informado.");
		}
			
			
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
