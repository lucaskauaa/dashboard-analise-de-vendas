package service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import model.Sale;

public class SalesAnalysisService {

	public static Map<String, Integer> getTotalSalesByCategory (List<Sale> salesList) {
		
		Map<String, Integer> totalByCategory = new TreeMap<>();
		
		salesList.stream()
			.collect(Collectors.groupingBy(Sale::getCategory))
			.forEach((k, v) -> totalByCategory.put(k, v.size()));
		
		return totalByCategory;
	}
}
