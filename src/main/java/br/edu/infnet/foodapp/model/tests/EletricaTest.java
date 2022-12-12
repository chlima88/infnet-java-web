package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Eletrica;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class EletricaTest {

	public static void main(String[] args) {
		
		try {
			Eletrica e1 = new Eletrica("Revisão Eletrica", "L01", 100, false);
			System.out.println("E1: " + e1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		
		try {
			Eletrica e2 = new Eletrica("Reparo circuito luzes", "L02", 350, true);
			e2.setIncendio(false);
			e2.setCircuitoDanificado("luzes");		
			System.out.println("E2: " + e2);		
			System.out.println("E2 Mao de obra: " + e2.obterPrecoMaoDeObra());
			System.out.println("E2 Preco final: " + e2.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Eletrica e3 = new Eletrica("Revisão circuito ignicao","L03",500, false);
			e3.setIncendio(true);
			e3.setCircuitoDanificado("ignicao");
			System.out.println("E3: " + e3);
			System.out.println("E3 Mao de obra: " + e3.obterPrecoMaoDeObra());
			System.out.println("E3 Preco final: " + e3.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
	}

}
