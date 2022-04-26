package com.amigoscode.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;

public class GettingStarted {
//TODO
	// 1. Find people aged less or equal 18
	// 2. Then change implementation to find first 10 people

	@Test
	public void imperativeApproach() throws IOException {
		// 1. Find people aged less or equal 18
		List<Person> people = MockData.getPeople();
		List<Person> peopleless18 = new ArrayList<Person>();
		for (Person p : people) {
			if (p.getAge() <= 18) {
				peopleless18.add(p);
			}
		}
		//peopleless18.forEach(System.out::println);
		
		
		// 2. Then change implementation to find first 10 people
		List<Person> firstTenPeopleless18 = new ArrayList<Person>();
		int counter = 0;
		for(Person p : people) {
			if(p.getAge() <= 18) {
				firstTenPeopleless18.add(p);
				counter ++ ;
				
				if(counter == 10) {
					break;
				}
			}
		}
		firstTenPeopleless18.forEach(System.out::println);
	}

	@Test
	public void declarativeApproachUsingStreams() throws Exception {
		List<Person> people = MockData.getPeople();
		// 1. Find people aged less or equal 18
		List<Person> peopleless18 = people.stream().filter(person -> person.getAge() <= 18)
				.collect(Collectors.toList());
		//peopleless18.forEach(System.out::println);
		
		// 2. Then change implementation to find first 10 people
		List<Person> firstTenPeopleless18 = people.stream().filter(person -> person.getAge() <= 18).limit(10).collect(Collectors.toList());
		firstTenPeopleless18.forEach(System.out::println);
	}
}
