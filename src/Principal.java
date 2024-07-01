import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> mapa = new HashMap<>();

		System.out.print("Informe o caminho do arquivo: ");
		String caminho = sc.nextLine();
		System.out.println();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String str = br.readLine();
			while (str != null) {
				String[] vetor = str.split(",");
				String nome = vetor[0];
				int numVoto = Integer.parseInt(vetor[1]);
				 if (mapa.containsKey(nome)) {
					 int cont = mapa.get(nome);
					 mapa.put(nome, cont + numVoto);
				 }
				 else {
					 mapa.put(nome, numVoto);
				 }
				str = br.readLine();
			
				
			 
			}

		}

		catch (IOException e) {
			System.out.print("Erro: " + e.getMessage());
		}
		
		for (String s : mapa.keySet()) {
			System.out.println("Nome do candidato: " + s + " com " + mapa.get(s) + " votos");
		}
		
		
				 

		sc.close();

	}

}
