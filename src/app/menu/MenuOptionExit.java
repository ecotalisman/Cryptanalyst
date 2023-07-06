package app.menu;

import static app.menu.MenuConstants.*;

public class MenuOptionExit extends MenuOption {
    @Override
    public void runApp() {
        System.out.println("Exit app!");
        isRunning = false;
    }
}
