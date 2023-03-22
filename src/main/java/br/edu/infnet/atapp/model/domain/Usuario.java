package br.edu.infnet.atapp.model.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private List<String> caracteristicas;
	private String tipo;
	private String empresa;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Servico> servicos;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Agendamento> agendamentos;

	public Usuario() {};
	
	public Usuario(String email, String senha) {
		this();
		this.email = email;
		this.senha = senha;	
	};
		
	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.nome = nome;			
	}

	public Usuario(
			String nome,
			String email,
			String senha,
			List<String> caracteristicas,
			String tipo,
			String empresa
		) {
		this(nome, email, senha);
		this.caracteristicas = caracteristicas;
		this.tipo = tipo;
		this.empresa = empresa;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public String toString() {
		
		return "id: " + this.id + "; " +
				"nome: " + this.nome + "; " +
				"email: " + this.email + "; " +
				"senha: " + this.senha + "; " +
				"caracteristicas: " + this.caracteristicas + "; " + 
				"tipo: " + this.tipo + "; " +
				"empresa: " + this.empresa;
				
	}
}
