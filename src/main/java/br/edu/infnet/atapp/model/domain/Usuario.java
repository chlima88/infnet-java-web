package br.edu.infnet.atapp.model.domain;

import java.util.List;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private List<String> caracteristicas;
	private String tipo;
	private String setor;
	
//	public Usuario() {};
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;		
	};
	
	public Usuario(
			String nome,
			String email,
			String senha,
			List<String> caracteristicas,
			String tipo,
			String setor
		) {
		this(email, senha);
		this.nome = nome;
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.setor = setor;
	}
	
	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getSenha() {
		return senha;
	}


	public List<String> getCaracteristicas() {
		return caracteristicas;
	}


	public String getTipo() {
		return tipo;
	}


	public String getSetor() {
		return setor;
	}
		

	public String toString() {
		
		return "nome: " + this.nome + "; " +
				"email: " + this.email + "; " +
				"senha: " + this.senha + "; " +
				"caracteristicas: " + this.caracteristicas + "; " + 
				"tipo: " + this.tipo + "; " +
				"setor: " + this.setor;
				
	}
}
