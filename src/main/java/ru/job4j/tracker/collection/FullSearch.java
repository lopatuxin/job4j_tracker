package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        list.forEach(s -> numbers.add(s.getNumber()));
        return numbers;
    }
}
