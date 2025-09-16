package controller;

import java.util.List;
import java.util.Map;

import model.Sale;
import service.SalesAnalysisService;

public class SalesAnalysisController {

	public static void displayTotalSalesByCategory(List<Sale> salesList) {

		Map<String, Integer> map =  SalesAnalysisService.getTotalSalesByCategory(salesList);
				
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			map.forEach((k, v) -> System.out.println(k + ": " + v)) ;
		}
				
	}

	public static void displayTop5BestSellingProducts (List<Sale> salesList) {
		
		Map<String, Integer> map = SalesAnalysisService.getTop5BestSellingProducts(salesList);
		
		if (map.isEmpty()) {
			System.out.println("Lista vazia!");
			
		} else {
			map.forEach((k, v) -> System.out.println(k + ": " + v)) ;
		}
	}
	
}
