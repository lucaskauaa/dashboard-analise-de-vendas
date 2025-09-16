package controller;

import java.util.List;
import java.util.Map;

import model.Sale;
import service.SalesAnalysisService;

public class SalesAnalysisController {

	public static void displayTotalSalesByCategory(List<Sale> salesList) {

		Map<String, Long> map =  SalesAnalysisService.getTotalSalesByCategory(salesList);
				
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			System.out.println("Total de vendas por categoria:\n");
			map.forEach((k, v) -> System.out.println(k + ": " + v)) ;
		}
				
	}

	public static void displayTop5BestSellingProducts (List<Sale> salesList) {
		
		Map<String, Integer> map = SalesAnalysisService.getTop5BestSellingProducts(salesList);
		
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			System.out.println("Top 5 produtos mais vendidos:\n");
			map.forEach((k, v) -> System.out.println(k + ": " + v)) ;
		}
	}
	
	public static void displayAverageValuePerSeller (List<Sale> salesList) {
		Map<String, Double> map = SalesAnalysisService.getAverageValuePerSeller(salesList);
		
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			System.out.println("Média de valor por vendedor:\n");
			map.forEach((k, v) -> System.out.printf("%s: R$ %.2f%n", k, v));
		}
	}
	
}
