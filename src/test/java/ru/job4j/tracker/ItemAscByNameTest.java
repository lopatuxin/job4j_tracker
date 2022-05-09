package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void sortAscending() {
        List<Item> items = Arrays.asList(
                new Item("Anton"),
                new Item("Van"),
                new Item("Gog")
        );
        List<Item> expected = Arrays.asList(
                new Item("Anton"),
                new Item("Gog"),
                new Item("Van")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }
}