package br.edu.infnet.atapp.model.domain;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private String[] caracteristicas;
	private String tipo;
	private String setor;
	
	public Usuario(
			String nome,
			String email,
			String senha,
			String[] caracteristicas,
			String tipo,
			String setor
		) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.setor = setor;
	}
		

	public String toString() {
		return "nome: " + nome + "; " +
				"email: " + email + "; " +
				"senha: " + senha + "; " +
				"caracteristicas: " + caracteristicas.toString() + "; " + 
				"tipo: " + tipo + "; " +
				"setor: " + setor;
				
	}
}
