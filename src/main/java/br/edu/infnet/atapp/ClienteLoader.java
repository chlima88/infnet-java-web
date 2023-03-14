package br.edu.infnet.atapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.service.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arquivo = "loadCliente.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				String linha = file.readLine();
				String[] dados = null; 
				
				while (linha != null) {
					
					dados = linha.split(";");
					
					Cliente cliente = new Cliente(dados[0],dados[1],dados[2]);
					clienteService.incluir(cliente);
					
					linha = file.readLine();
				}
				
				file.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Cliente - "+e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Cliente");
		}
	}

}
