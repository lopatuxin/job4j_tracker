package ru.job4j.tracker.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = map::put;
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");

        BiPredicate<Integer, String> predicate = (i, s) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            if (predicate.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer = System.out::println;
        Function<String, String> function = String::toUpperCase;
        for (String s : strings) {
            consumer.accept(function.apply(s));
        }
    }
}
