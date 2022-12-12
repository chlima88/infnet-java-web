package br.edu.infnet.atapp.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.atapp.model.domain.Agendamento;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.exceptions.CategoriaInvalidaException;
import br.edu.infnet.atapp.model.exceptions.CircuitoInvalidoException;
import br.edu.infnet.atapp.model.exceptions.ClienteIndefinidoException;
import br.edu.infnet.atapp.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.atapp.model.exceptions.DuracaoAtendimentoException;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;
import br.edu.infnet.atapp.model.exceptions.ServicoIndefinidoException;
import br.edu.infnet.atapp.model.exceptions.TamanhoInvalidoException;

public class ArquivoTest {

	public static void main(String[] args) {

		try {
			String arquivo = "agendamentos.txt";
			
			try {
				FileReader fileReader = new FileReader(arquivo);
				BufferedReader file = new BufferedReader(fileReader);
				
				FileWriter fileWriter = new FileWriter("out_" + arquivo);
				BufferedWriter fileW = new BufferedWriter(fileWriter);
				
				
				String linha = file.readLine();
				String[] dados = null; 
				
				Agendamento agendamento = null;
				List<Servico> servicos = new ArrayList<Servico>();
						
				while (linha != null) {
					
					dados = linha.split(";");
					
					switch (dados[0].toUpperCase()) {
					
						case "A": 
							try {
								Cliente cliente = new Cliente(dados[3],dados[4],dados[5]);
								agendamento = new Agendamento(cliente, servicos);
								agendamento.setConfirmado("sim".equalsIgnoreCase(dados[2]) ? true : false );
								agendamento.setDuracaoEmMinutos(Integer.valueOf(dados[1]));

								fileW.write(agendamento.obterPedido());
								
								servicos = new ArrayList<Servico>();
								
							} catch (DuracaoAtendimentoException 
									| ClienteIndefinidoException 
									| ServicoIndefinidoException error) {
								System.out.println("Agendamento: " + error.getMessage());
							} catch (ClienteInvalidoException error) {
								System.out.println("Cliente: " + error.getMessage());
							} 						
							break;
							
						case "L": 
							try {
								Lanternagem servico = new Lanternagem(
										dados[1], 
										dados[2], 
										Integer.valueOf(dados[3]), 
										Boolean.valueOf(dados[4])
										);
								servico.setLocalDanificado(dados[5]);
								servico.setTamanhoAvaria(dados[6]);
								
								servicos.add(servico);		
								
							}catch (PrecoBaseInvalidoException 
									| TamanhoInvalidoException error) {
								System.out.println("Servico: " + error.getMessage());
							} 
							break;
							
						case "E": 
							try {
								Eletrica servico = new Eletrica(
										dados[1], 
										dados[2], 
										Integer.valueOf(dados[3]), 
										Boolean.valueOf(dados[4])
										);
								servico.setCircuitoDanificado((dados[5]));
								servico.setIncendio(Boolean.valueOf(dados[6]));
								
								servicos.add(servico);

							} catch (PrecoBaseInvalidoException  
									| CircuitoInvalidoException error) {
								System.out.println("Servico: " + error.getMessage());
							} 
							break;
							
						case "M": 
							try {
								Mecanica servico = new Mecanica(
										dados[1], 
										dados[2], 
										Integer.valueOf(dados[3]), 
										Boolean.valueOf(dados[4])
										);
								servico.setCategoriaServico(dados[5]);
								servico.setProblemaMotor(Boolean.valueOf(dados[6]));
								
								servicos.add(servico);		
								
							}catch (PrecoBaseInvalidoException 
									| CategoriaInvalidaException error) {
								System.out.println("Servico: " + error.getMessage());
							} 
							break;
							
						default:
							System.out.println("Registro invalido");
							break;
						
					}
					linha = file.readLine();
				}
				
				fileW.close();
				file.close();
				fileReader.close();
			} catch (IOException error) {
				System.out.println("[ERRO] " + error.getMessage());
			}
		} finally {
			System.out.println("Programa encerrado!");
		}
	}
}
