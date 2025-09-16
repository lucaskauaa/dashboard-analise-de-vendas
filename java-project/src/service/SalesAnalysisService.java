package service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Sale;

public class SalesAnalysisService {

	public static Map<String, Integer> getTotalSalesByCategory (List<Sale> salesList) {
		
		Map<String, Integer> totalByCategory = new HashMap<>();
		
		salesList.stream()
			.collect(Collectors.groupingBy(Sale::getCategory))
			.forEach((k, v) -> totalByCategory.put(k, v.size()));
		
		return totalByCategory.entrySet()
			.stream()
			.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
			.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(e1, e2) -> e1,
					LinkedHashMap::new));
		 
	}
	
	public static Map<String, Integer> getTop5BestSellingProducts (List<Sale> salesList) {
		
		Map<String, Integer> quantityOfEachProduct = new HashMap<>();
		
		salesList.stream()
			.collect(Collectors.groupingBy(Sale::getProduct))
			.forEach((k, v) -> {
				
				int totalQuantity = v.stream()
					.map(Sale::getQuantity)
					.collect(Collectors.summingInt(Integer::intValue));
				
				quantityOfEachProduct.put(k, totalQuantity);
			});
		
		return quantityOfEachProduct.entrySet()
			.stream()
			.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
			.limit(5)
			.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(e1, e2) -> e1,
					LinkedHashMap::new
					));
	}
}
