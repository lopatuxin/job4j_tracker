package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUi {

    public static void main(String[] args) {
        Item item = new Item("Anton", 5);
        System.out.println(item.toString());
    }
}
