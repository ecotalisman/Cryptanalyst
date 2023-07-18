package app.menu;

import app.keys.*;

import java.util.HashMap;

import static app.menu.MenuConstants.*;

public class MenuKeyEncrypt {
    protected HashMap<Integer, Key> keyItems = new HashMap<>();

    public MenuKeyEncrypt() {
        keyItems.put(KEY_1, new KeyOne());
        keyItems.put(KEY_2, new KeyTwo());
        keyItems.put(KEY_3, new KeyThree());
    }

    public Key runKey() {
        Key key = null;
        while (isRunning) {
            System.out.print("\n" + ENTER_KEY_CONSOLE);
            String userInput = scanner.nextLine();
            key = keyItems.getOrDefault(enterUserInput(userInput), new IncorrectKey());
            if (key instanceof IncorrectKey) {
                key.key();
                continue;
            }
            break;
        }
        return key;
    }

    int enterUserInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
