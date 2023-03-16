package br.edu.infnet.atapp.model.domain;

import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String codigo;
	private float precoBase;
	private boolean terceirizado;
	
	public Servico() {};
	
	public Servico(String nome, String codigo, float precoBase, boolean terceirizado) throws PrecoBaseInvalidoException {
		
		this(); 
		
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

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public float getPrecoBase() {
		return this.precoBase;
	}
	
	public void setPrecoBase(float precoBase) {
		this.precoBase = precoBase;
	}

	public Boolean getTerceirizado() {
		return this.terceirizado;
	}
	
	public void setTerceirizado(boolean terceirizado) {
		this.terceirizado = terceirizado;
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
