package controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Sale;
import service.SalesAnalysisService;
import util.InputReader;

public class SalesAnalysisController {
	
	private static <K, V> void displayMap (Map<K, V> map, String title, String printMessage) {
		
		if (map.isEmpty()) {
			System.out.println("Nenhuma venda foi encontrada!");
			
		} else {
			System.out.println(title);
			map.forEach((k, v) -> System.out.println(String.format(printMessage, k, v)));
		}
		
	}
	
	private static <T> void displayList (List<T> list, String emptyListMessage, String title) {
		
		if (list.isEmpty()) {
			System.out.println(emptyListMessage);
		} else {
			System.out.println(title);
			list.forEach(System.out::println);
		}
	}

	public static void displayTotalSalesByCategory (List<Sale> salesList) {

		Map<String, Long> totalSalesByCategory =  SalesAnalysisService.getTotalSalesByCategory(salesList);
		
		displayMap(totalSalesByCategory, "Total de vendas por categoria:\n", "%s: %d");
	}
	
	public static void displayTotalSalesByRegion (List<Sale> salesList) {

		Map<String, Long> totalSalesByRegion =  SalesAnalysisService.getTotalSalesByRegion(salesList);
		
		displayMap(totalSalesByRegion, "Total de vendas por região:\n", "%s: %d");
	}

	public static void displayTop5BestSellingProducts (List<Sale> salesList) {
		
		Map<String, Integer> bestSellingProducts = SalesAnalysisService.getTop5BestSellingProducts(salesList);
		
		displayMap(bestSellingProducts, "Top 5 produtos mais vendidos:\n", "%s: %d");
		
	}
	
	public static void displayAverageValuePerSeller (List<Sale> salesList) {
		
		Map<String, Double> averageValuePerSelling = SalesAnalysisService.getAverageValuePerSeller(salesList);
		
		displayMap(averageValuePerSelling, "Valor médio por vendedor:\n", "%s: R$ %.2f");
		
	}
	
	public static void displayTotalValuePerSeller (List<Sale> salesList) {
		
		Map<String, Double> totalValuePerSelling = SalesAnalysisService.getTotalValuePerSeller(salesList);
		
		displayMap(totalValuePerSelling, "Valor total por vendedor:\n", "%s: R$ %.2f");
		
	}
	
	public static void displayPercentageOfSalesByCategory (List<Sale> salesList) {
		
		Map<String, Integer> percentageOfSalesByCategory = SalesAnalysisService.getPercentageOfSalesByCategory(salesList);
		
		displayMap(percentageOfSalesByCategory, "Porcentagem de vendas por categoria:\n", "%s: %d%%");
		
	}
	
	public static void displaySalesByMonthAndYear (Scanner sc, List<Sale> salesList) {
		
		List<String> salesDate = SalesAnalysisService.getSalesDate(salesList);
		
		displayList(salesDate, "Não foram encontradas nenhuma ocorrência de vendas!", "Meses onde ocorreram vendas:\n");
		
		int year = InputReader.readInt(sc, "\nDigite o ano que você deseja consultar: ");
		
		int month = InputReader.readInt(sc, "Digite o mês que você deseja consultar: ");
		
		List<Sale> salesByMonthAndYear = SalesAnalysisService.getSalesByMonthAndYear(salesList, year, month);
		
		displayList(
				salesByMonthAndYear,
				"\nNão foram encontradas nenhuma ocorrência de vendas nesta data!\nInsira uma data válida!",
				"\nVendas em " + month + "/" + year + ":"
				);
	}
	
}
