package br.edu.infnet.atapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.EletricaService;

@Order(3)
@Component
public class EletricaLoader implements ApplicationRunner {
	
	@Autowired
	EletricaService eletricaService;

	@Value("classpath:data/loadEletrica.txt")
	Resource resourceFile;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			try {
				InputStreamReader fileReader = new InputStreamReader(resourceFile.getInputStream());
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
					Usuario usuario = new Usuario();
					usuario.setId(Integer.valueOf(dados[5]));
					servico.setUsuario(usuario);
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
