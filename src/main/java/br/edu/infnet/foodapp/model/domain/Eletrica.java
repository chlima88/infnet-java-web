package br.edu.infnet.foodapp.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import br.edu.infnet.foodapp.model.exceptions.CircuitoInvalidoException;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class Eletrica extends Servico {
	
	private String circuitoDanificado; // ignição, arranque, luzes, acessorios
	private boolean incendio;


	public Eletrica(String nome, String codigo, float preco, boolean terceirizado) throws PrecoBaseInvalidoException {
		super(nome, codigo, preco, terceirizado);
		this.incendio = false;
	}


	@Override
	public float obterPrecoMaoDeObra() {
		return super.getPrecoBase() * this.obterTaxaMaoDeObra() * (this.incendio ? 1.25f : 1f);
	}
	
	private float obterTaxaMaoDeObra() {
		float taxa = 0;
		
		switch(this.circuitoDanificado.toLowerCase()) {
		case "luzes":
			taxa = 1f;
			break;
		case "ignicao":
			taxa = 1.1f;
			break;
		case "arranque":
			taxa = 1.25f;
			break;
		case "acessorios":
			taxa = 1.4f;
		}
		
		return taxa;
	}

	@Override
	public String toString() {		
		
		StringJoiner string = new StringJoiner(";");
		string.add(super.toString());
		string.add(this.circuitoDanificado);
		string.add(String.valueOf(this.incendio));
		
		return string.toString();
	}

	public String getCircuitoDanificado() {
		return this.circuitoDanificado;
	}

	public void setCircuitoDanificado(String circuitoDanificado) throws CircuitoInvalidoException {
		List<String> validOptions = new ArrayList<String>(Arrays.asList("luzes","ignicao","arranque","acessorios"));
		
		if (!validOptions.contains(circuitoDanificado)) {
			throw new CircuitoInvalidoException("O circuito informado invalido ["+ circuitoDanificado +"]. "
					+ "Opcoes validas: " + validOptions);
		}
		
		this.circuitoDanificado = circuitoDanificado;
	}
	
	public boolean isIncendio() {
		return this.incendio;
	}

	public void setIncendio(boolean incendio) {
		this.incendio = incendio;
	}

	
	

}
