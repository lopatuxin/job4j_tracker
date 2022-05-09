package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void sortInDescending() {
        List<Item> items = Arrays.asList(
                new Item("Anton"),
                new Item("Van"),
                new Item("Gog")
        );
        List<Item> expected = Arrays.asList(
                new Item("Van"),
                new Item("Gog"),
                new Item("Anton")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}