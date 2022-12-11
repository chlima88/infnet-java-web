package br.edu.infnet.foodapp.model.tests;

import br.edu.infnet.foodapp.model.domain.Lanternagem;

public class LaternagemTest {

	public static void main(String[] args) {

		Lanternagem b1 = new Lanternagem("Recuperação de Paralama", "L01", 100);
		
		Lanternagem b2 = new Lanternagem("Recuperação de Portamalas", "L02", 500);
		b2.setLocalDanificado("Traseira");
		b2.setTamanhoAvaria("G");
		
		Lanternagem b3 = new Lanternagem(
				"Recuperacao de Porta",
				"L03",
				350,
				"G",
				"Frontal Direita"
				);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		System.out.println(b2.obterPrecoMaoDeObra());
		System.out.println(b2.obterPrecoFinal());
	}

}
