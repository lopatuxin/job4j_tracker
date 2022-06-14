package ru.job4j.tracker.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors
                        .toMap(student -> student.getSurname(),
                                student -> student,
                                (s1, s2) -> s1));
    }
}
