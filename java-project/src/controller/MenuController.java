package controller;

import java.util.List;
import java.util.Scanner;

import model.Sale;
import util.InputReader;

public class MenuController {
	
	public static void displayMenu (Scanner sc, List<Sale> salesList) {
		
		int choice = 0;
		
		do {
			StringBuilder menuText = new StringBuilder();

			menuText.append("\n====================================\n");
			menuText.append("Selecione uma opção:\n");
			menuText.append("\n[1] Total de vendas por categoria\n");
			menuText.append("[2] Total de vendas por região\n");
			menuText.append("[3] Top 5 produtos mais vendidos\n");
			menuText.append("[4] Valor médio por vendedor\n");
			menuText.append("[5] Valor total por vendedor\n");
			menuText.append("[6] Porcentagem de vendas por categoria\n");
			menuText.append("[7] Vendas por mês e ano\n");
			menuText.append("[8] Gerar arquivo de texto com relatório completo\n");
			menuText.append("[0] Sair.\n");
			menuText.append("\nResposta: ");
			
			choice = InputReader.readInt(sc, menuText.toString());
			
			System.out.println();

			switch (choice) {
			case 1 -> SalesAnalysisController.displayTotalSalesByCategory(salesList);
			case 2 -> SalesAnalysisController.displayTotalSalesByRegion(salesList);
			case 3 -> SalesAnalysisController.displayTop5BestSellingProducts(salesList);
			case 4 -> SalesAnalysisController.displayAverageValuePerSeller(salesList);
			case 5 -> SalesAnalysisController.displayTotalValuePerSeller(salesList);
			case 6 -> SalesAnalysisController.displayPercentageOfSalesByCategory(salesList);
			case 7 -> SalesAnalysisController.displaySalesByMonthAndYear(sc, salesList);
			case 8 -> FileGenerationController.generateFile(sc, salesList);
			case 0 -> System.out.println("Programa encerrado.");
			default -> System.out.println("Opção inválida!");
			}

		} while (choice != 0);
		
	}

}
