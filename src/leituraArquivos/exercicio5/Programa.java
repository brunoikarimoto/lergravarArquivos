package leituraArquivos.exercicio5;

import java.io.IOException;

public class Programa {
	public static void main(String[] args) throws IOException{
		Exercicio5 a = new Exercicio5();
		int total;
		int[] grupos = new int[6];
		
		grupos = a.calculaPorGrupo();
		total = a.calculaTotal();
		a.salvaArquivo(total, grupos);
		
		System.out.println("Arquivo criado (resultado.txt).");
	}
}
