package leituraArquivos.exercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio7 {
	public Aluno[] leituraDados() throws FileNotFoundException {
		String path = "/home/bruno/facul_up/java/leituraArquivos/alunos.csv";
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		
		sc.nextLine();
		
		int totalDeLinhas = 0;
		while(sc.hasNext()) {
			sc.nextLine();
			totalDeLinhas++;
		}
		
		Aluno[] vetorDeAlunos = new Aluno[totalDeLinhas];
		sc.close();
		Scanner sc1 = new Scanner(arquivo);
		
		sc1.nextLine();
		
		int i = 0;
		while(sc1.hasNext()) {
			String linha = sc1.nextLine();
			String[] vetor = linha.split(";");
			
			Aluno aluno = new Aluno();
			aluno.matricula = Integer.parseInt(vetor[0]);
			aluno.nome = vetor[1];
			vetor[2] = vetor[2].replace(",", ".");
			aluno.nota = Float.parseFloat(vetor[2]);
			
			vetorDeAlunos[i] = aluno;
			
			i++;
		}
		
		return vetorDeAlunos;
	}
	
	public void salvaAprovados(Aluno[] alunos) throws IOException {
		String path = "/home/bruno/facul_up/java/leituraArquivos/aprovados.txt";
		FileWriter arquivo = new FileWriter(path);
		PrintWriter gravador = new PrintWriter(arquivo);
		
		for(int i = 0; i < alunos.length; i++) {
			if(alunos[i].nota >= 6) {
				gravador.println("Aprovado: " + alunos[i].nome + "; Nota: " + alunos[i].nota);
			}
		}
		
		gravador.close();
	}
}
