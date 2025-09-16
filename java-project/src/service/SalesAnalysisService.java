package service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import model.Sale;

public class SalesAnalysisService {
	
	private static <K, V> Map<K, V> sortMapByValue (Map<K, V> map, Comparator<Entry<K, V>> comparator) {
		
		return map.entrySet()
			.stream()
			.sorted(comparator)
			.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(v1, v2) -> v1,
					LinkedHashMap::new));
	}

	public static Map<String, Long> getTotalSalesByCategory (List<Sale> salesList) {
		
		Map<String, Long> totalSalesByCategory = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getCategory,
					Collectors.counting()
					));
		
		totalSalesByCategory = sortMapByValue(totalSalesByCategory, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
	
		return totalSalesByCategory;	 
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
		
		Map<String, Double> avarageValuePerSeller = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getSeller,
					Collectors.averagingDouble(Sale::getTotalValue)
					));
		
		avarageValuePerSeller = sortMapByValue(avarageValuePerSeller, (v1, v2) -> v2.getValue().compareTo(v1.getValue()));
		
		return avarageValuePerSeller;
	}
	
	public static Map<String, Double> getTotalValuePerSeller (List<Sale> salesList) {
		
		Map<String, Double> valuePerSeller = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getSeller,
					Collectors.summingDouble(s -> s.getTotalValue())
					));
		
		valuePerSeller = sortMapByValue(valuePerSeller, (v1, v2) -> v2.getValue().compareTo(v1.getValue()));
		
		return valuePerSeller;
	}
	
}
