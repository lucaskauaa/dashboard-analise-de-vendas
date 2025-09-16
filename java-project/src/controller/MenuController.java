package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Sale;

public class MenuController {
	
	public static void displayMenu (Scanner sc, List<Sale> salesList) {
		
		int choice = 0;
		
		do {
			StringBuilder menuText = new StringBuilder();

			menuText.append("\n====================================\n");
			menuText.append("Selecione uma opção:\n");
			menuText.append("[1] Total de vendas por categoria\n");
			menuText.append("[5] Sair.\n");
			menuText.append("\nResposta: ");

			System.out.print(menuText.toString());
			
			choice = sc.nextInt();
			sc.nextLine();
			
			System.out.println();

			switch (choice) {
			case 1 -> SalesAnalysisController.displayTotalSalesByCategory(salesList);
			case 5 -> System.out.println("Programa encerrado.");
			default -> System.out.println("Opção inválida!");
			}

		} while (choice != 5);
		
	}

}
