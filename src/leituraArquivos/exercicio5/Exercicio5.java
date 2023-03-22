package leituraArquivos.exercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio5 {
	public int calculaTotal() throws FileNotFoundException {
		String path = "/home/bruno/facul_up/java/leituraArquivos/grupos-tabulados.txt";
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		int result=0;
		
		sc.nextLine();
		
		while(sc.hasNext()) {
			String linha = sc.nextLine();
			String[] vetor = linha.split("	");
			String numeros = vetor[1];
			
			result += Integer.parseInt(numeros);
		}
		
		//System.out.println("Total: " + result);
		
		return result;
	}
	
	public int[] calculaPorGrupo() throws FileNotFoundException {
		int grupoA=0, grupoB=0, grupoC=0,grupoD=0,grupoE=0, grupoF=0;
		String path = "/home/bruno/facul_up/java/leituraArquivos/grupos-tabulados.txt";
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		int[] result = new int[6];
		
		sc.nextLine();
		
		while(sc.hasNext()) {
			String linha = sc.nextLine();
			String[] vetor = linha.split("	");
			String numeros = vetor[1];
			String grupos = vetor[0];
			
			if(grupos.startsWith("A")) {
				grupoA += Integer.parseInt(vetor[1]);
				result[0] = grupoA;
			}
			else if(grupos.startsWith("B")) {
				grupoB += Integer.parseInt(numeros);
				result[1] = grupoB;
			}
			else if(grupos.startsWith("C")) {
				grupoC += Integer.parseInt(numeros);
				result[2] = grupoC;
			}
			else if(grupos.startsWith("D")) {
				grupoD += Integer.parseInt(numeros);
				result[3] = grupoD;
			}
			else if(grupos.startsWith("E")) {
				grupoE += Integer.parseInt(numeros);
				result[4] = grupoE;
			}
			else {
				grupoF += Integer.parseInt(numeros);
				result[5] = grupoF;
			}
		}
		
		/*System.out.println("Grupo A: " + grupoA);
		System.out.println("Grupo B: " + grupoB);
		System.out.println("Grupo C: " + grupoC);
		System.out.println("Grupo D: " + grupoD);
		System.out.println("Grupo E: " + grupoE);
		System.out.println("Grupo F: " + grupoF);*/
		
		return result;
	}
	
	public void salvaArquivo(int total, int[] grupos) throws IOException {
		String path = "/home/bruno/facul_up/java/leituraArquivos/resultado.txt";
		FileWriter arquivo = new FileWriter(path);
		PrintWriter gravador = new PrintWriter(arquivo);
		
		gravador.println("Grupo A: " + grupos[0]);
		gravador.println("Grupo B: " + grupos[1]);
		gravador.println("Grupo C: " + grupos[2]);
		gravador.println("Grupo D: " + grupos[3]);
		gravador.println("Grupo E: " + grupos[4]);
		gravador.println("Grupo F: " + grupos[5]);
		gravador.println("Total: " + total);
		
		gravador.close();
	}
}
