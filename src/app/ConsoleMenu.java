package app;

import app.menu.*;

import java.util.HashMap;

import static app.menu.MenuConstants.*;

public class ConsoleMenu {
    protected HashMap<Integer, MenuOption> menuItems = new HashMap<>();

    public ConsoleMenu() {
        menuItems.put(ENCRYPT, new MenuOptionEncrypt());
        menuItems.put(DECRYPT, new MenuOptionDecrypt());
        menuItems.put(EXIT_APP, new MenuOptionExit());
    }

    public void run() {
        while (isRunning) {
            System.out.print("\n" + MENU_INFO);
            String userInput = scanner.nextLine();
            MenuOption menuItem = menuItems.getOrDefault(enterUserInput(userInput), new MenuOptionIncorrectItem());

            menuItem.runApp();
        }
    }

    int enterUserInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
