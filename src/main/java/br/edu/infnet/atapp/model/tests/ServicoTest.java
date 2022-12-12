package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;

public class ServicoTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("\r\nTest case 1: Instanciar uma classe filha com sucesso\r\n"
					+ "Saida Esperada: classe instanciada\r\n");
			Eletrica servico = new Eletrica("Revisão Eletrica", "L01", 100, false);
			System.out.println("Servico: " + servico);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 2: Instanciar uma classe filha com preco menor que zero\r\n"
					+ "Saida Esperada: mensagem de erro\r\n");
			Lanternagem servico = new Lanternagem("Recuperação de Paralama", "L01", -100, false);
			System.out.println("Servico: " + servico);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 3: Instanciar uma classe filha com preco igual a zero\r\n"
					+ "Saida Esperada: mensagem de erro\r\n");
			Mecanica servico = new Mecanica("Alinhamento", "M01", 0, true);
			System.out.println("Servico: " + servico);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
	}

}
