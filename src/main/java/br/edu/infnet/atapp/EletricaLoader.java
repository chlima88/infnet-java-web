package br.edu.infnet.atapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.service.EletricaService;

@Component
public class EletricaLoader implements ApplicationRunner {
	
	@Autowired
	EletricaService eletricaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arquivo = "loadEletrica.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				String linha = file.readLine();
				String[] dados = null; 
				
				while (linha != null) {
					
					dados = linha.split(";");
					
					Eletrica servico = new Eletrica(
							dados[0], 
							dados[1], 
							Integer.valueOf(dados[2]), 
							Boolean.valueOf(dados[3])
						);
					servico.setCircuitoDanificado(dados[4]);
					eletricaService.incluir(servico);
					
					linha = file.readLine();
				}
				
				file.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Eletrica - "+e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Eletrica");
		}
		
		

	}
	
}
