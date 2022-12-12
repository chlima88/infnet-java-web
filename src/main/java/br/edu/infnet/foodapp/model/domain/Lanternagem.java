package br.edu.infnet.foodapp.model.domain;

import java.util.StringJoiner;

import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class Lanternagem extends Servico {
	
	private String tamanhoAvaria; //P,M,G
	private String localDanificado;
		
	
	public Lanternagem(String nome, String codigo, float precoBase, boolean terceirizado) throws PrecoBaseInvalidoException {
		super(nome, codigo, precoBase, terceirizado);
	}

	

	@Override
	public float obterPrecoMaoDeObra() {		
		return super.getPrecoBase() * this.obterTaxaMaoDeObra() ;
	}
	
	private float obterTaxaMaoDeObra() {
		float taxa = 0;
		
		switch(this.tamanhoAvaria.toUpperCase()) {
		case "P":
			taxa = 1f;
			break;
		case "M":
			taxa = 1.15f;
			break;
		case "G":
			taxa = 1.3f;
			break;
		}
		
		return taxa;
	}

	@Override
	public String toString() {		
		
		StringJoiner string = new StringJoiner(";");
		string.add(super.toString());
		string.add(this.tamanhoAvaria);
		string.add(this.localDanificado);
		
		return string.toString();
	}
	
 	public String getTamanhoAvaria() {
		return this.tamanhoAvaria;
	}

	public void setTamanhoAvaria(String tamanhoAvaria) {
		this.tamanhoAvaria = tamanhoAvaria;
	}
	
	public String getLocalDanificado() {
		return this.localDanificado;
	};
	
	public void setLocalDanificado(String localDanificado) {
		this.localDanificado = localDanificado;
	};
	

}
