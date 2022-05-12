package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = -1;
        if (o1.length() <= o2.length()) {
            for (int i = 0; i < o1.length(); i++) {
                result = Character.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    break;
                } else {
                    result = Integer.compare(o1.length(), o2.length());
                }
            }
        } else {
            for (int i = 0; i < o2.length(); i++) {
                result = Character.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    break;
                } else {
                    result = Integer.compare(o1.length(), o2.length());
                }
            }
        }
        return result;
    }
}
