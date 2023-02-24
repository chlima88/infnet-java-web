package br.edu.infnet.atapp.model.domain;

import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;

public class Cliente {

	private Integer id;
	private String nome;
	private String documento;
	private String contato;
	
	public Cliente() {};
	
	public Cliente(String nome, String documento, String contato) throws ClienteInvalidoException {
		
		this();
		
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
	
	
	public Integer getId(){
		return this.id;
	};
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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
