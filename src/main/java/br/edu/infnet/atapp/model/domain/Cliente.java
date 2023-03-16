package br.edu.infnet.atapp.model.domain;

import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TCliente")
public class Cliente {

	@Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String documento;
	private String contato;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
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
	
	
	public Integer  getId(){
		return this.id;
	};
	
	public void setId(Integer  id) {
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
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
