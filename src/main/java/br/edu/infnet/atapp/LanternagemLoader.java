package br.edu.infnet.atapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.service.LanternagemService;

@Component
public class LanternagemLoader implements ApplicationRunner {
	
	@Autowired
	LanternagemService lanternagemService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arquivo = "loadLanternagem.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				String linha = file.readLine();
				String[] dados = null; 
				
				while (linha != null) {
					
					dados = linha.split(";");
					
					Lanternagem servico = new Lanternagem(
							dados[0], 
							dados[1], 
							Integer.valueOf(dados[2]), 
							Boolean.valueOf(dados[3])
						);
					servico.setTamanhoAvaria(dados[4]);
					lanternagemService.incluir(servico);
					
					linha = file.readLine();
				}
				
				file.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Lanternagem - "+e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Lanternagem");
		}	
	}	
}
