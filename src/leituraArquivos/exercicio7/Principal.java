package leituraArquivos.exercicio7;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		Exercicio7 a = new Exercicio7();
		
		Aluno[] vetor = a.leituraDados();
		
		try {
			a.salvaAprovados(vetor);
			
			System.out.println("Arquivo criado. (aprovados.txt)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
