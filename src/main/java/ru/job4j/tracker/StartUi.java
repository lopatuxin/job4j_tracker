package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUi {
    private final Output output;

    public StartUi(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        output.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            output.println(i + "." + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new EditAction(output));
        actions.add(new FindByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ShowAllActions(output));
        actions.add(new ExitAction());
        new StartUi(output).init(input, tracker, actions);

    }
}
