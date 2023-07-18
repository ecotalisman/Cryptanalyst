package app.keys;

import app.menu.MenuConstants;

import static app.menu.MenuConstants.*;

public class IncorrectKey extends Key {
    @Override
    public void key() {
        System.out.println(WRONG_NUMBER);
    }
}
