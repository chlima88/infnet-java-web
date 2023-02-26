package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.infnet.atapp.model.domain.Lanternagem;

public class LanternagemRepository {
	
	private static Map<Integer, Lanternagem> servicos = new HashMap<Integer, Lanternagem>();
	private static Integer id = 0;	
	
	static {
		try {
			Lanternagem servico = new Lanternagem("Recuperacao de Paralama", "L01", 100, false);
			servico.setTamanhoAvaria("P");
			save(servico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static Lanternagem save(Lanternagem servico) throws Exception {
		
		try {
			findByCode(servico.getCodigo());			
		} catch (Exception e) {
			servico.setId(id);
			servicos.put(id++, servico);
			return servico;
		} 
		throw new Exception("Codigo ja cadastrado!");

	};
	
	public static Lanternagem delete(Integer key) throws Exception {
		
		Lanternagem servico = servicos.remove(key);
		if (servico == null) throw new Exception("O id informado é inválido ou não existe!");
		return servico;
	}
	
	public static List<Lanternagem> findByName(String nome) {
		
		List<Lanternagem> servicosEncontrados = new ArrayList<Lanternagem>();
	
		for (Lanternagem servico: servicos.values()) {
			if (servico.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				servicosEncontrados.add(servico);				
			}
		};
		
		return servicosEncontrados;
		
	};
	
	public static Lanternagem findByCode(String codigo) throws Exception {
		
		Lanternagem servicoEncontrado = null;
	
		for (Lanternagem servico: servicos.values()) {
			if (servico.getCodigo().equalsIgnoreCase(codigo.toLowerCase()) ) {
				servicoEncontrado = servico;				
			}
		};
		
		if (servicoEncontrado == null) throw new Exception("Codigo não encontrado!");
		
		return servicoEncontrado;
		
	};
	
	public static Collection<Lanternagem> findAll() {
		return servicos.values();
	};
	
	public static void update(String codigoBuscado, Lanternagem servico) throws Exception {
		
		try {
			if (codigoBuscado.equalsIgnoreCase(servico.getCodigo())) {
				servicos.put(servico.getId(), servico);
				return;
			} else {
				findByCode(servico.getCodigo());
			}
		} catch(Exception error) {
			servicos.put(servico.getId(), servico);
			return;
		}
		
		throw new Exception("O codigo informado já está em uso!");
		
		
	};
	
	public static int count() {
		return servicos.size();
	}
}
