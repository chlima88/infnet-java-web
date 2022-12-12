package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;
import br.edu.infnet.atapp.model.exceptions.TamanhoInvalidoException;

public class LaternagemTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("\r\nTest case 1: Instanciar Lanternagem com sucesso\r\n"
					+ "Saida Esperada: classe instanciada\r\n");
			Lanternagem servico = new Lanternagem("Recuperação de Paralama", "L01", 100, false);
			servico.setLocalDanificado("Traseira");
			servico.setTamanhoAvaria("G");
			System.out.println("Servico: " + servico);
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		

		try {
			System.out.println("\r\nTest case 2: Definir um tamanho invalido para avaria\r\n"
					+ "Saida Esperada: mensagem de erro\r\n");
			Lanternagem servico = new Lanternagem("Recuperação de Paralama", "L01", 100, false);
			servico.setTamanhoAvaria("F");
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 3: Validar o ajuste do valor de acordo com tamanhoAvaria\r\n"
					+ "Saida Esperada: diferentes valores para P, M e G\r\n");
			Lanternagem servico = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			servico.setLocalDanificado("Traseira");
			servico.setTamanhoAvaria("P");
			System.out.println("Servico: " + servico);
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final: " + servico.obterPrecoFinal());
			servico.setTamanhoAvaria("M");
			System.out.println("Servico: " + servico);
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final: " + servico.obterPrecoFinal());
			servico.setTamanhoAvaria("G");
			System.out.println("Servico: " + servico);
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico preco final: " + servico.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
	}

}
