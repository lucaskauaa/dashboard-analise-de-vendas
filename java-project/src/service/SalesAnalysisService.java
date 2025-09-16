package service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Sale;

public class SalesAnalysisService {

	public static Map<String, Long> getTotalSalesByCategory (List<Sale> salesList) {
		
		Map<String, Long> totalByCategory = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getCategory,
					Collectors.counting()
					));
	
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
		
	Map<String, Integer> quantityOfEachProduct = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getProduct,
					Collectors.summingInt(s -> s.getQuantity().intValue())
					));
		
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
	
	public static Map<String, Double> getAverageValuePerSeller (List<Sale> salesList) {
		
		Map<String, Double> avarage = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getSeller,
					Collectors.averagingDouble(Sale::getTotalValue)
					));
		
		return avarage.entrySet()
			.stream()
			.sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
			.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(v1, v2) -> v1,
					LinkedHashMap::new));
	}
}
