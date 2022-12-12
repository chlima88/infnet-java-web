package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.exceptions.CircuitoInvalidoException;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;

public class EletricaTest {

	public static void main(String[] args) {
		
		// Casos de teste
		// 1 - Instancia sem utilização de setters
		// 2 - Incendio false/true -> validar calculo
		// 3 - Circuito invalido -> Exibir erro
		
		try {
			System.out.println("\r\nTest case 1: Instanciar Eletrica com sucesso\r\n"
					+ "Saida Esperada: classe instanciada\r\n");
			Eletrica servico = new Eletrica("Revisão Eletrica", "L01", 100, false);
			System.out.println(servico);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		
		try {
			System.out.println("\r\nTest case 2: Validar o ajuste do preco devido a taxa de incendio\r\n"
					+ "Saida Esperada: Maior preco final quando incendio é igual a true\r\n");
			Eletrica servico = new Eletrica("Reparo circuito luzes", "L02", 350, true);
			servico.setIncendio(false);
			servico.setCircuitoDanificado("luzes");		
			System.out.println("Servico (sem taxa): " + servico);		
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico Preco final: " + servico.obterPrecoFinal());
			servico.setIncendio(true);
			System.out.println("Servico (com taxa):" + servico);		
			System.out.println("Servico Mao de obra: " + servico.obterPrecoMaoDeObra());
			System.out.println("Servico Preco final: " + servico.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | CircuitoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
		try {
			System.out.println("\r\nTest case 3: Exibir mensagem de erro quando informar um circuito invalido\r\n"
					+ "Saida Esperada: mensagem de erro\r\n");
			Eletrica servico = new Eletrica("Revisão circuito ignicao","L03",500, false);
			servico.setIncendio(true);
			servico.setCircuitoDanificado("abcd");
		} catch (PrecoBaseInvalidoException | CircuitoInvalidoException error) {
			System.out.println("Servico: " + error.getMessage());
		}
		
	}

}
