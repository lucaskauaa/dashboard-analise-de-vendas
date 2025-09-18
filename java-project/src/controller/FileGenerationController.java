package controller;

import java.util.List;
import java.util.Scanner;

import model.Sale;
import util.InputReader;
import util.WriteFile;

public class FileGenerationController {
	
	public static void generateFile(Scanner sc, List<Sale> salesList) {
		
		String path = InputReader.readString(sc, "Insira o endereço do arquivo .txt onde o relatório deverá ser gerado: ");
		
		boolean fileGeneratedSuccessfully = WriteFile.writeFile(path, salesList);
		
		String feedbackMessage = fileGeneratedSuccessfully ? "\nArquivo gerado em: " + path : "\nArquivo não encontrado! Insira um caminho de arquivo válido.";
	
		System.out.println(feedbackMessage);
	}

}
