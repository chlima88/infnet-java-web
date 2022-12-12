package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Mecanica;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class MecanicaTest {

	public static void main(String[] args) {
		
		try {
			Mecanica m1 = new Mecanica("Alinhamento", "M01", 200, false);
			System.out.println("M1: " + m1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {		
			Mecanica m2 = new Mecanica("Troca de oleo", "M02", 150, true);
			m2.setCategoriaServico("revisao");
			m2.setProblemaMotor(false);
			System.out.println("M2: " + m2);
			System.out.println("M2 Mao de obra: " + m2.obterPrecoMaoDeObra());
			System.out.println("M2 preco final: " + m2.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try { 
			Mecanica m3 = new Mecanica("Substituicao bloco motor","L03",800, false);
			m3.setCategoriaServico("manutencao");
			m3.setProblemaMotor(true);
			System.out.println("M3: " + m3);
			System.out.println("M3 Mao de obra: " + m3.obterPrecoMaoDeObra());
			System.out.println("M3 Preco final: " + m3.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
	}

}
