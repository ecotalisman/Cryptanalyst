package app.menu;

import java.util.Scanner;

public final class MenuConstants {
    public static final int ENCRYPT = 1;
    public static final int DECRYPT = 2;
    public static final int EXIT_APP = 3;
    public static final int KEY_1 = 1;
    public static final int KEY_2 = 2;
    public static final int KEY_3 = 3;
    public static final int KEY_BruteForce = 4;
    public static final String WRONG_PATH = "Please, enter the correct file path again!";
    public static final String FILE_NOT_FOUND = "The file you're trying to access doesn't exist. Please check the file path and try again.";
    public static final String WRONG_NUMBER = "Invalid input! Please enter a valid number...";
    public static final String MENU_INFO =
            """
                    Please enter to number:
                    Encrypt Text File - 1
                    Decrypt Text File - 2
                    Exit Console - 3
                         """;

    public static final String ENTER_KEY_CONSOLE =
            """
                    Please select a key:
                    Enter '1' for a key of '4'.
                    Enter '2' for a key of '7'.
                    Enter '3' for a key of '8'.
                    """;

    public static final String ENTER_KEY_CONSOLE_Decrypt =
            """
                    Please select a key:
                    Enter '1' for a key of '4'.
                    Enter '2' for a key of '7'.
                    Enter '3' for a key of '8'.
                    Enter '4' for a BruteForce'
                    """;
    public static boolean isRunning = true;
    public static Scanner scanner = new Scanner(System.in);

    private MenuConstants() {
    }
}
