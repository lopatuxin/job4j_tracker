package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -2, 0, 3, 4, 5);
        List<Integer> result = numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
