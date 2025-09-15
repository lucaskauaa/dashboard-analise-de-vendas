package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import model.Sale;
import util.ReadFile;

public class SalesListService {

	public static List<Sale> getSalesList (Scanner sc) {
		
		Function<String, Sale> recievsStringReturnsSale = element -> {
			String[] fields = element.split(",");

			return new Sale(
					Integer.parseInt(fields[0]),
					fields[1],
					fields[2],
					Double.parseDouble(fields[3]),
					Integer.parseInt(fields[4]),
					LocalDate.parse(fields[5]),
					fields[6],
					fields[7]
			);

		};

		List<Sale> salesList = new ArrayList<>();

		boolean repeat;

		do {
			System.out.print("Insira o caminho do arquivo: ");
			String filePath = sc.nextLine();

			salesList = ReadFile.getListOfElements(filePath, recievsStringReturnsSale);

			repeat = salesList.isEmpty();
		} while (repeat);
		
		return salesList;
	}
}
