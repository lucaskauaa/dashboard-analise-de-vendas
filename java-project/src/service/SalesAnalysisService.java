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
		
		return sortMapByValue(totalSalesByCategory, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		 
	}
	
	public static Map<String, Long> getTotalSalesByRegion (List<Sale> salesList) {
		
		Map<String, Long>  totalSalesByRegion = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getRegion,
					Collectors.counting()
					));
		
		return sortMapByValue(totalSalesByRegion, Map.Entry.comparingByValue(Comparator.reverseOrder()));
	
	}
	
	public static Map<String, Integer> getTop5BestSellingProducts (List<Sale> salesList) {
		
		Map<String, Integer> quantityOfEachProduct = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getProduct,
					Collectors.summingInt(s -> s.getQuantity().intValue())
					));
		
		return quantityOfEachProduct.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
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
		
		return sortMapByValue(avarageValuePerSeller, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
	}
	
	public static Map<String, Double> getTotalValuePerSeller (List<Sale> salesList) {
		
		Map<String, Double> valuePerSeller = salesList.stream()
			.collect(Collectors.groupingBy(
					Sale::getSeller,
					Collectors.summingDouble(Sale::getTotalValue)
					));
		
		return sortMapByValue(valuePerSeller, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
	}
	
	public static Map<String, Integer> getPercentageOfSalesByCategory (List<Sale> salesList) {
		
		Map<String, Integer> percentageByCategory = new LinkedHashMap<>();
		
		salesList.stream()
			.collect(Collectors.groupingBy(Sale::getCategory))
			.forEach((category, currentList) -> {
				
				int percentage = currentList.size() * 100 / salesList.size();
				
				percentageByCategory.put(category, percentage);
			});
		
		return sortMapByValue(percentageByCategory, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
	}
	
	public static List<String> getSalesDate (List<Sale> salesList) {
		
		return salesList.stream()
			.map(s -> s.getDate().getMonthValue() + "/" + s.getDate().getYear())
			.distinct()
			.collect(Collectors.toList());
	}
	
	public static List<Sale> getSalesByMonthAndYear (List<Sale> salesList, Integer year, Integer month) {
		
		return salesList.stream()
			.filter(s -> s.getDate().getYear() == year && s.getDate().getMonthValue() == month)
			.collect(Collectors.toList());
	}
}
