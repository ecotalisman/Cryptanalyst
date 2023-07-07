package app.menu;

import app.keys.KeyBruteForce;
import app.keys.IncorrectKey;
import app.keys.Key;

import static app.menu.MenuConstants.*;

public class MenuKeyDecrypt extends MenuKeyEncrypt {

    public MenuKeyDecrypt() {
        super();
        keyItems.put(KEY_BruteForce, new KeyBruteForce());
    }

    @Override
    public Key runKey() {
        Key key = null;
        var keyBruteForce = new KeyBruteForce();
        while (isRunning) {
            System.out.print("\n" + ENTER_KEY_CONSOLE_Decrypt);
            String userInput = scanner.nextLine();
            key = keyItems.getOrDefault(enterUserInput(userInput), new IncorrectKey());
            if (key instanceof IncorrectKey) {
                key.key();
                continue;
            } else if (key instanceof KeyBruteForce) {
                key = keyBruteForce;
                keyBruteForce.key();
                break;
            }
            break;
        }
        return key;
    }

    @Override
    int enterUserInput(String input) {
        return super.enterUserInput(input);
    }
}