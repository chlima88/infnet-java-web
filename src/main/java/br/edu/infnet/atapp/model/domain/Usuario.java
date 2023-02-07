package br.edu.infnet.atapp.model.domain;

public class Usuario {

	String nome;
	String email;
	String senha;
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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


	public String toString() {
		return "Nome: " + nome + "; " +
				"email: " + email + "; " +
				"senha: " + senha;
				
	}
}
