import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {
    private EncryptDecryptText encryptDecryptText;
    private static final int ENCRYPT = 1;
    private static final int DECRYPT = 2;
    private static final int EXIT_APP = 3;
    private static final String WRONG_PATH = "Please, enter the correct file path again!";
    private static final String FILE_NOT_FOUND = "The file you're trying to access doesn't exist. Please check the file path and try again.";
    private static final String ENTER_CONSOLE =
            """
                    Please enter to number:
                    Encrypt Text File - 1
                    Decrypt Text File - 2
                    Exit Console - 3
                         """;
    private static boolean valid = true;
    final Scanner scanner = new Scanner(System.in);

    public void startApp() {

        while (valid) {
            System.out.print("\n" + ENTER_CONSOLE);
            try {
                int number = scanner.nextInt();
                switch (number) {
                    case ENCRYPT -> {
                        encryptFile();
                        valid = false;
                    }
                    case DECRYPT -> {
                        decryptFile();
                        valid = false;
                    }
                    case EXIT_APP -> {
                        exitApp();
                        valid = false;
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
        EncryptDecryptText encryptDecryptText = new EncryptDecryptText(new FileConvertToChars(filePathOpen(), filePathSave()));
        encryptDecryptText.chooseKeyAndAction("1");
    }

    private void decryptFile() {
        EncryptDecryptText decryptText = new EncryptDecryptText(new FileConvertToChars(filePathOpen(), filePathSave()));
        decryptText.chooseKeyAndAction("2");
    }

    private String filePathOpen() {
        Scanner scannerPath = new Scanner(System.in);

        while (valid) {
            System.out.println("Enter the file path to OPEN:");
            String path = scannerPath.nextLine();

            try {
                if (Files.exists(Path.of(path))) {
                    valid = false;
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

    private String filePathSave() {
        Scanner scannerPathSave = new Scanner(System.in);
        System.out.println("Enter the file path to SAVE:");
        String path = scannerPathSave.nextLine();
        return path;
    }



    private void exitApp() {
        System.out.println("Exit app!");
        valid = false;
    }
}
