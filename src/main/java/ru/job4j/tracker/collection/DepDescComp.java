package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.split("/")[0].equals(o2.split("/")[0]) ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}