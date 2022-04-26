package com.amigoscode.examples;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class DistinctAndSets {
	
    @Test
    public void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinctNums = new ArrayList<Integer>();
        numbers .forEach(num -> {
        	if (!distinctNums.contains(num)) {
        		distinctNums.add(num);
        	}
        });
        //System.out.println(distinctNum);
    }

    @Test
    public void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinctNumbers  = numbers.stream().map(num -> num).collect(Collectors.toSet());
        System.out.println(distinctNumbers);
    }
}
