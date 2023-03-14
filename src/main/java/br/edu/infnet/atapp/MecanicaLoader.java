package br.edu.infnet.atapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.service.MecanicaService;

@Component
public class MecanicaLoader implements ApplicationRunner {
	
	@Autowired
	MecanicaService mecanicaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arquivo = "loadMecanica.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				String linha = file.readLine();
				String[] dados = null; 
				
				while (linha != null) {
					
					dados = linha.split(";");
					
					Mecanica servico = new Mecanica(
							dados[0], 
							dados[1], 
							Integer.valueOf(dados[2]), 
							Boolean.valueOf(dados[3])
						);
					servico.setCategoriaServico(dados[4]);
					mecanicaService.incluir(servico);
					
					linha = file.readLine();
				}
				
				file.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Mecanica - "+e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Mecanica");
		}	
		
	}
	
}
