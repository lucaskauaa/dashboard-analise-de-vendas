package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadFile {

	public static <T> List<T> getListOfElements (String filePath, Function<String, T> operation) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			return reader.lines()
					.map(operation)
					.collect(Collectors.toList());

		} catch (IOException e) {
			System.out.println("Url incorreta!\n");
			
			return Collections.emptyList();
		}

	}

}
