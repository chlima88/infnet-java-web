package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.atapp.model.domain.Eletrica;

@Repository
public class EletricaRepository {
	
	private static Map<Integer, Eletrica> servicos = new HashMap<Integer, Eletrica>();
	private static Integer id = 0;	
		
	public Eletrica save(Eletrica mecanica) throws Exception {
		
		try {
			findByCode(mecanica.getCodigo());			
		} catch (Exception e) {
			mecanica.setId(id);
			servicos.put(id++, mecanica);
			return mecanica;
		} 
		throw new Exception("Codigo ja cadastrado!");

	};
	
	public Eletrica delete(Integer key) throws Exception {
		
		Eletrica mecanica = servicos.remove(key);
		if (mecanica == null) throw new Exception("O id informado é inválido ou não existe!");
		return mecanica;
	}
	
	public static List<Eletrica> findByName(String nome) {
		
		List<Eletrica> mecanicasEncontrados = new ArrayList<Eletrica>();
	
		for (Eletrica mecanica: servicos.values()) {
			if (mecanica.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				mecanicasEncontrados.add(mecanica);				
			}
		};
		
		return mecanicasEncontrados;
		
	};
	
	public Eletrica findByCode(String codigo) throws Exception {
		
		Eletrica mecanicaEncontrado = null;
	
		for (Eletrica mecanica: servicos.values()) {
			if (mecanica.getCodigo().equalsIgnoreCase(codigo.toLowerCase()) ) {
				mecanicaEncontrado = mecanica;				
			}
		};
		
		if (mecanicaEncontrado == null) throw new Exception("Codigo não encontrado!");
		
		return mecanicaEncontrado;
		
	};
	
	public Collection<Eletrica> findAll() {
		return servicos.values();
	};
	
	public void update(String codigoBuscado, Eletrica mecanica) throws Exception {
		
		try {
			if (codigoBuscado.equalsIgnoreCase(mecanica.getCodigo())) {
				servicos.put(mecanica.getId(), mecanica);
				return;
			} else {
				findByCode(mecanica.getCodigo());
			}
		} catch(Exception error) {
			servicos.put(mecanica.getId(), mecanica);
			return;
		}
		
		throw new Exception("O codigo informado já está em uso!");
		
		
	};
	
	public static int count() {
		return servicos.size();
	}
}
