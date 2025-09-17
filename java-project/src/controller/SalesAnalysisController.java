package controller;

import java.util.List;
import java.util.Map;

import model.Sale;
import service.SalesAnalysisService;

public class SalesAnalysisController {
	
	private static <K, V> void displayMap (Map<K, V> map, String text01, String text02) {
		
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			System.out.println(text01);
			map.forEach((k, v) -> System.out.println(String.format(text02, k, v)));
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
	
}
