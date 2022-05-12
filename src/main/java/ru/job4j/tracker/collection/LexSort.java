package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] str1 = o1.split("\\.");
        String[] str2 = o2.split("\\.");
        int num1 = Integer.parseInt(str1[0]);
        int num2 = Integer.parseInt(str2[0]);
        return Integer.compare(num1, num2);
    }
}
