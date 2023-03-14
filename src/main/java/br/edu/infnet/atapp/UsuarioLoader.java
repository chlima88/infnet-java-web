package br.edu.infnet.atapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			String arquivo = "loadUsuario.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				String linha = file.readLine();
				String[] dados = null; 
				
				while (linha != null) {
					
					dados = linha.split(";");
					
					List<String> caracteristicas = Arrays.asList(dados[3].split(" "));
					
					Usuario usuario = new Usuario(dados[0],dados[1],dados[2],caracteristicas,dados[4],dados[5]);
					usuarioService.incluir(usuario);
					
					linha = file.readLine();
				}
				
				file.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("[Erro] DataLoader Usuario - "+e.getMessage());
			}
		} finally {
			System.out.println("[Sucesso] DataLoader Usuario");
		}
	}
}
		
