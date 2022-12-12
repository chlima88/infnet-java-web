package br.edu.infnet.foodapp.model.domain;

import java.util.StringJoiner;

public class Mecanica extends Servico {
	
	private String categoriaServico; // revisao, troca, manutencao
	private boolean problemaMotor;


	public Mecanica(String nome, String codigo, float precoBase, boolean terceirizado) {
		super(nome, codigo, precoBase, terceirizado);
		this.categoriaServico = null;
		this.problemaMotor = false;
	}

	@Override
	public float obterPrecoMaoDeObra() {		
		return super.getPrecoBase() * this.obterTaxaMaoDeObra() * (this.problemaMotor ? 1.15f : 1f ) ;
	}
	
	private float obterTaxaMaoDeObra() {
		float taxa = 0;
		
		switch(this.categoriaServico.toLowerCase()) {
		case "revisao":
			taxa = 1f;
			break;
		case "troca":
			taxa = 1.15f;
			break;
		case "manutencao":
			taxa = 1.3f;
			break;
		}
		
		return taxa;
	}

	
	public String getCategoriaServico() {
		return categoriaServico;
	}

	public void setCategoriaServico(String categoriaServico) {
		this.categoriaServico = categoriaServico;
	}

	public boolean isProblemaMotor() {
		return problemaMotor;
	}

	public void setProblemaMotor(boolean problemaMotor) {
		this.problemaMotor = problemaMotor;
	}
	
	@Override
	public String toString() {		
		
		StringJoiner string = new StringJoiner(";");
		string.add(super.toString());
		string.add(this.categoriaServico);
		string.add(String.valueOf(this.problemaMotor));
		
		return string.toString();
	}

}
