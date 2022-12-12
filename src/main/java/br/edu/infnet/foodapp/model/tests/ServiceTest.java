package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Eletrica;
import br.edu.infnet.foodapp.model.domain.Lanternagem;
import br.edu.infnet.foodapp.model.domain.Mecanica;
import br.edu.infnet.foodapp.model.exceptions.PrecoBaseInvalidoException;

public class ServiceTest {

	public static void main(String[] args) {
		
		// Casos de teste
		// 1 - Testar preços invalidos
		// 2 - Validar calculo do terceirizado 

		try {
			Eletrica e1 = new Eletrica("Revisão Eletrica", "L01", 100, false);
			System.out.println("E1: " + e1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Lanternagem l1 = new Lanternagem("Recuperação de Paralama", "L01", 100, false);
			System.out.println("L1: " + l1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
		
		try {
			Mecanica m1 = new Mecanica("Alinhamento", "M01", 200, true);
			System.out.println("M1: " + m1);
		} catch (PrecoBaseInvalidoException error) {
			System.out.println(error.getMessage());
		}
	}

}
