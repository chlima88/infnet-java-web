package br.edu.infnet.atapp.model.tests;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.exceptions.PrecoBaseInvalidoException;
import br.edu.infnet.atapp.model.exceptions.TamanhoInvalidoException;

public class LaternagemTest {

	public static void main(String[] args) {
		
		/* Casos de Teste 
		 * 
		 * 1 - Tentar utilizar tamanhos validos e invalidos 
		 * 
		 * */
		

		try {
			Lanternagem l1 = new Lanternagem("Recuperação de Paralama", "L01", 100, false);
			l1.setTamanhoAvaria("F");
			System.out.println("L1: " + l1);
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("L1: " + error.getMessage());
		}
		
		try {
			Lanternagem l2 = new Lanternagem("Recuperação de Portamalas", "L02", 500, true);
			l2.setLocalDanificado("Traseira");
			l2.setTamanhoAvaria("G");
			System.out.println("L2: " + l2);
			System.out.println("L2 Mao de obra: " + l2.obterPrecoMaoDeObra());
			System.out.println("L2 preco final: " + l2.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("L2: " + error.getMessage());
		}
		
		try {
			Lanternagem l3 = new Lanternagem("Recuperacao de Porta","L03",350,false);
			l3.setLocalDanificado("Frontal Direita");
			l3.setTamanhoAvaria("M");
			System.out.println("L3: " + l3);
			System.out.println("L3 Mao de obra: " + l3.obterPrecoMaoDeObra());
			System.out.println("L3 Preco final: " + l3.obterPrecoFinal());
		} catch (PrecoBaseInvalidoException | TamanhoInvalidoException error) {
			System.out.println("L3: " + error.getMessage());
		}
		
	}

}
