package app.menu;

import static app.menu.MenuConstants.*;

public class MenuOptionIncorrectItem extends MenuOption {
    @Override
    public void runApp() {
        System.out.println(WRONG_NUMBER);
    }
}
