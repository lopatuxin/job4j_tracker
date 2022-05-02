package ru.job4j.tracker;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StartUiTest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(new EditAction(out), new ExitAction());
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Edit item" + ln
                        + "1.Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0.Edit item" + ln
                        + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("Test"));
        Input in = new StubInput(new String[] {"0", "1"});
        List<UserAction> actions = List.of(new ShowAllActions(output), new ExitAction());
        new StartUi(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Show all items" + ln
                + "1.Exit" + ln
                + "=== Show all items ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0.Show all items" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(new String[] {"0", "Test", "1"});
        List<UserAction> actions = List.of(new FindByNameAction(output), new ExitAction());
        new StartUi(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Find by name" + ln
                + "1.Exit" + ln
                + "=== Find items by name ===" + ln
                + item + ln
                + "Menu:" + ln
                + "0.Find by name" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = List.of(new FindByIdAction(output), new ExitAction());
        new StartUi(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0.Find by id" + ln
                + "1.Exit" + ln
                + "=== Find item by id ===" + ln
                + item + ln
                +  "Menu:" + ln
                + "0.Find by id" + ln
                + "1.Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0.Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0.Exit" + ln
                )
        );
    }
}