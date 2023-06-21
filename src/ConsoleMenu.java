import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {
    private static final int ENCRYPT = 1;
    private static final int DECRYPT = 2;
    private static final int EXIT_APP = 3;
    private static final int KEY_5 = 5;
    private static final int KEY_7 = 7;
    private static final int KEY_10 = 10;
    private static final String WRONG_PATH = "Please, enter the correct file path again!";
    private static final String FILE_NOT_FOUND = "The file you're trying to access doesn't exist. Please check the file path and try again.";
    private static final String MENU_INFO =
            """
                    Please enter to number:
                    Encrypt Text File - 1
                    Decrypt Text File - 2
                    Exit Console - 3
                         """;

    private static final String ENTER_KEY_CONSOLE =
            """
                    Please select a key:
                    Enter '1' for a key of '5'.
                    Enter '2' for a key of '7'.
                    Enter '3' for a key of '10'.
                    """;
    private static boolean isRunning = true;
    private EncryptText encryptText;
    final Scanner scanner = new Scanner(System.in);

    public void startApp() {
        while (isRunning) {
            System.out.print("\n" + MENU_INFO);
            try {
                int number = scanner.nextInt();
                switch (number) {
                    case ENCRYPT -> {
                        encryptFile();
                        isRunning = false;
                    }
                    case DECRYPT -> {
                        decryptFile();
                        isRunning = false;
                    }
                    case EXIT_APP -> {
                        exitApp();
                        isRunning = false;
                    }
                    default -> System.out.println(Constants.WRONG_NUMBER);
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println(Constants.WRONG_NUMBER);
                scanner.next();
            }
        }
    }

    public void chooseKeyAndAction(int action) {
        while (isRunning) {

            System.out.println(ENTER_KEY_CONSOLE);
            try {
                int key = scanner.nextInt();
                switch (key) {
                    case 1 -> {
                        if (1 == action) {
                            encrypt(KEY_5);
                        } else decrypt(KEY_5);
                        isRunning = false;
                    }
                    case 2 -> {
                        if (1 == action) {
                            encrypt(KEY_7);
                        } else decrypt(KEY_7);
                        isRunning = false;
                    }
                    case 3 -> {
                        if (1 == action) {
                            encrypt(KEY_10);
                        } else decrypt(KEY_10);
                        isRunning = false;
                    }
                    default -> System.out.println(Constants.WRONG_NUMBER);
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println(Constants.WRONG_NUMBER);
                scanner.next();
            }
        }
    }

    private void encryptFile() {
        EncryptText encryptText = new EncryptText(new FileOpenSaveAndConvert(openFileOption(), saveFileOption()));
        chooseKeyAndAction(ENCRYPT);
    }

    private void decryptFile() {
        EncryptText decryptText = new EncryptText(new FileOpenSaveAndConvert(openFileOption(), saveFileOption()));
        chooseKeyAndAction(DECRYPT);
    }

    private String openFileOption() {
        Scanner scannerPathOpen = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Enter the file path to OPEN:");
            String path = scannerPathOpen.nextLine();

            try {
                if (Files.exists(Path.of(path))) {
                    isRunning = false;
                    return path;
                } else {
                    System.out.println(FILE_NOT_FOUND);
                }
            } catch (InvalidPathException e) {
                System.out.println(WRONG_PATH);
            }
        }
        throw new FileNotFoundException("File path could not be validated");
    }

    private String saveFileOption() {
        Scanner scannerPathSave = new Scanner(System.in);
        System.out.println("Enter the file path to SAVE:");
        String path = scannerPathSave.nextLine();
        return path;
    }

    private void exitApp() {
        System.out.println("Exit app!");
        isRunning = false;
    }
}
