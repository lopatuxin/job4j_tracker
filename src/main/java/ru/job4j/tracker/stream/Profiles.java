package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .toList();
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .toList();
    }

}
