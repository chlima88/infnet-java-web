package br.edu.infnet.atapp.model.domain;

import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;

public abstract class Servico {

	private String nome;
	private String codigo;
	private float precoBase;
	private boolean terceirizado;
	
	public Servico(String nome, String codigo, float precoBase, boolean terceirizado) throws PrecoBaseInvalidoException {
		
		if (precoBase <= 0) {
			throw new PrecoBaseInvalidoException("O preco deve ser superior a zero.");
		}
		
		this.nome = nome;
		this.codigo = codigo;
		this.precoBase = precoBase;
		this.terceirizado = terceirizado;
	}
	
	public abstract float obterPrecoMaoDeObra();
	
	public float obterPrecoFinal() {
		return this.terceirizado ? this.obterPrecoMaoDeObra() * 1.2f : this.obterPrecoMaoDeObra();
	};	

	public String getNome() {
		return this.nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public float getPrecoBase() {
		return this.precoBase;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.codigo);
		sb.append(";");
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.precoBase);
		sb.append(";");
		sb.append(this.terceirizado);
		
		return sb.toString();
	}
	
		
}
