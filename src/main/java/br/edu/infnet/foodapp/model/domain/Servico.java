package br.edu.infnet.foodapp.model.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Servico {

	private String nome;
	private String codigo;
	private float precoBase;
	private List<Peca> pecasSubstituidas;
	
	public Servico(String nome, String codigo, float precoBase) {
		this.nome = nome;
		this.codigo = codigo;
		this.precoBase = precoBase;
		this.pecasSubstituidas = new ArrayList<Peca>();
	}
	
	public abstract float obterPrecoPecas();
	public abstract float obterPrecoMaoDeObra();
	
	public float obterPrecoFinal() {
		return this.obterPrecoPecas() + this.obterPrecoMaoDeObra();
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
	
	public List<Peca> getPecasSubstituidas() {
		return this.pecasSubstituidas;
	}
	
	public void setPecasSubstituidas(List<Peca> pecas) {
		this.pecasSubstituidas = pecas;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.codigo);
		sb.append(";");
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.precoBase);
		
		return sb.toString();
	}
	
		
}
