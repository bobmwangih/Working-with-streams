package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxLengthForSingleLineDescription;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

	@Test
	void yourFirstTransformationWithMap() throws IOException {
		List<Person> people = MockData.getPeople();
		List<PersonDTO> dtos = people.stream().filter(person -> person.getAge() < 30)
				/*
				 * .map(p -> { return new PersonDTO(p.getId(), p.getFirstName(), p.getAge()); })
				 */
				.map(PersonDTO::map).collect(Collectors.toList());
		// dtos.forEach(System.out::println);
		assertThat(dtos.size()).isEqualTo(people.size());
	}

	@Test
	void mapToDoubleAndFindAverageCarPrice() throws IOException {
		List<Car> cars = MockData.getCars();
		Double averagePrices = (cars.stream().map(car -> car.getPrice()).reduce((a,b)->a+b).orElse(0.0))/cars.size();
		System.out.println(averagePrices);
	}

	@Test
	public void reduce() {
//sum		
		int[] integers = { 1, 2, 3, 4, 99, 100, 121, 1302, 199 };
		int sum1 = Arrays.stream(integers).reduce(0, (num1, num2) -> num1 + num2);
		int sum = Arrays.stream(integers).reduce((num1, num2) -> num1 + num2).orElse(0);
		// System.out.println(sum1);
//concat
		String[] words = { "Kenya", "Hakuna", "Matata!" };
		String concated = Arrays.stream(words).reduce((word1, word2) -> word1 + "--" + word2).orElse("");
		// System.out.println(concated);
//longest word
		Optional<String> longestWord = Arrays.stream(words)
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
		longestWord.ifPresent(System.out::println);

	}
}
