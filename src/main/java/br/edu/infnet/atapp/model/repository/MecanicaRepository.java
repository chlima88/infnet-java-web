package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.infnet.atapp.model.domain.Mecanica;

public class MecanicaRepository {
	
	private static Map<Integer, Mecanica> servicos = new HashMap<Integer, Mecanica>();
	private static Integer id = 0;	
	
	static {
		try {
			Mecanica servico = new Mecanica("Alinhamento", "M01", 200, false);
			servico.setCategoriaServico("revisao");
			save(servico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static Mecanica save(Mecanica mecanica) throws Exception {
		
		try {
			findByCode(mecanica.getCodigo());			
		} catch (Exception e) {
			mecanica.setId(id);
			servicos.put(id++, mecanica);
			return mecanica;
		} 
		throw new Exception("Codigo ja cadastrado!");

	};
	
	public static Mecanica delete(Integer key) throws Exception {
		
		Mecanica mecanica = servicos.remove(key);
		if (mecanica == null) throw new Exception("O id informado é inválido ou não existe!");
		return mecanica;
	}
	
	public static List<Mecanica> findByName(String nome) {
		
		List<Mecanica> mecanicasEncontrados = new ArrayList<Mecanica>();
	
		for (Mecanica mecanica: servicos.values()) {
			if (mecanica.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				mecanicasEncontrados.add(mecanica);				
			}
		};
		
		return mecanicasEncontrados;
		
	};
	
	public static Mecanica findByCode(String codigo) throws Exception {
		
		Mecanica mecanicaEncontrado = null;
	
		for (Mecanica mecanica: servicos.values()) {
			if (mecanica.getCodigo().equalsIgnoreCase(codigo.toLowerCase()) ) {
				mecanicaEncontrado = mecanica;				
			}
		};
		
		if (mecanicaEncontrado == null) throw new Exception("Codigo não encontrado!");
		
		return mecanicaEncontrado;
		
	};
	
	public static Collection<Mecanica> findAll() {
		return servicos.values();
	};
	
	public static void update(String codigoBuscado, Mecanica mecanica) throws Exception {
		
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
