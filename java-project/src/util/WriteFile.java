package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Sale;
import service.SalesAnalysisService;

public class WriteFile {
	
	private static <K, V> void write (Map<K, V> map, BufferedWriter writer, String title, String text) throws IOException {
		
			writer.write("=====================================\n");
			writer.write(title);
			writer.newLine();
			
			for (Entry<K, V> entry : map.entrySet()) {
				
				writer.write(String.format(text, entry.getKey(), entry.getValue()));
				writer.newLine();
			}
			
			writer.newLine();
			
	}
	
	public static boolean writeFile (String path, List<Sale> salesList) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			
			write(
					SalesAnalysisService.getTotalSalesByCategory(salesList),
					writer,
					"Total de vendas por categoria:\n",
					"%s: %d"
					);
			
			write(
					SalesAnalysisService.getTotalSalesByRegion(salesList),
					writer,
					"Total de vendas por região:\n",
					"%s: %d"
					);
			
			write(
					SalesAnalysisService.getTop5BestSellingProducts(salesList),
					writer,
					"\nTop 5 produtos mais vendidos:\n",
					"%s: %d"
					);
			
			write(
					SalesAnalysisService.getAverageValuePerSeller(salesList),
					writer,
					"Valor médio por vendedor:\n",
					"%s: R$ %.2f"
					);
			 
			write(
					SalesAnalysisService.getTotalValuePerSeller(salesList),
					writer,
					"Valor total por vendedor:\n",
					"%s: R$ %.2f");
			 
			write(
					SalesAnalysisService.getPercentageOfSalesByCategory(salesList),
					writer,
					"Porcentagem de vendas por categoria:\n",
					"%s: %d%%"
					);
			
			return true;
			
		} catch (IOException e) {
			
			return false;
		}
		
	}

}
