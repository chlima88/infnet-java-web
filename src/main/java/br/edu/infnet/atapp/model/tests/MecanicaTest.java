package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.exceptions.CategoriaInvalidaException;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;

public class MecanicaTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("\r\nTest case 1: Instanciar Mecanica com sucesso\r\n"
					+ "Saida Esperada: classe instanciada\r\n");
			Mecanica servico = new Mecanica("Alinhamento", "M01", 200, false);
			System.out.println(servico);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 2: Definir uma categoria invalida\r\n"
					+ "Saida Esperada: mensagem de erro\r\n");
			Mecanica servico = new Mecanica("Troca de oleo", "M02", 150, true);
			servico.setCategoriaServico("xxxx");
			servico.setProblemaMotor(false);
			System.out.println("Servico: " + servico);
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final: " + servico.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try { 
			System.out.println("\r\nTest case 3: Validar o ajuste do preco devido a taxa de problema no motor\r\n"
					+ "Saida Esperada: Maior preco final quando problemaMotor é igual a true\r\n");
			Mecanica servico = new Mecanica("Substituicao bloco motor","L03",800, false);
			servico.setCategoriaServico("manutencao");
			servico.setProblemaMotor(false);
			System.out.println("Servico (com taxa): " + servico);
			System.out.println("Servico Mao de obra (com taxa): " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final (com taxa): " + servico.obterPrecoFinal());
			servico.setProblemaMotor(true);
			System.out.println("Servico (sem taxa): " + servico);
			System.out.println("Servico Mao de obra (sem taxa): " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final (sem taxa): " + servico.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | CategoriaInvalidaException error) {
			System.out.println("Servico: " + error.getMessage());
		}
	}

}
