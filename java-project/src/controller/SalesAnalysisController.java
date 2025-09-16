package controller;

import java.util.List;

import model.Sale;
import service.SalesAnalysisService;

public class SalesAnalysisController {

	public static void displayTotalSalesByCategory(List<Sale> salesList) {

		SalesAnalysisService.getTotalSalesByCategory(salesList)
			.forEach((k, v) -> System.out.println(k + ": " + v));
	}

	
}
