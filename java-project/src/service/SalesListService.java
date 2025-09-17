package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Sale;
import util.InputReader;
import util.ReadFile;

public class SalesListService {
	
	private static Sale receivesStringReturnsSale (String line) {
		String[] fields = line.split(",");

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
	}

	public static List<Sale> getSalesList (Scanner sc) {

		List<Sale> salesList = new ArrayList<>();

		boolean repeat;

		do {
			
			String filePath = InputReader.readString(sc, "Insira o caminho do arquivo: ");

			salesList = ReadFile.getListOfElements(filePath, SalesListService::receivesStringReturnsSale);

			repeat = salesList.isEmpty();
			
		} while (repeat);
		
		return salesList;
	}
}
