package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUi {

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(dateTimeFormatter));
    }
}
