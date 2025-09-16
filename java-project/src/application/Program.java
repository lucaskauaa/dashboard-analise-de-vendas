package application;

import java.util.List;
import java.util.Scanner;

import controller.MenuController;
import model.Sale;
import service.SalesListService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Sale> salesList = SalesListService.getSalesList(sc);

		salesList.forEach(System.out::println);
		
		MenuController.displayMenu(sc, salesList);
		
		sc.close();

	}

}