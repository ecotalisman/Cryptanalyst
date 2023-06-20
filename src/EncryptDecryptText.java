import java.util.InputMismatchException;
import java.util.Scanner;

public class EncryptDecryptText {
    private final FileConvertToChars fileConvertToChars;
    private static final int KEY_5 = 5;
    private static final int KEY_7 = 7;
    private static final int KEY_10 = 10;
    private static final String UKR = Constants.UKRAINIAN_LETTERS;
    private static final String ENG = Constants.ENGLISH_LETTERS;
    private static final String PUNCTUATION = Constants.PUNCTUATION;
    private static final String ENTER_KEY_CONSOLE =
            """
                    Please select a key:
                    Enter '1' for a key of '5'.
                    Enter '2' for a key of '7'.
                    Enter '3' for a key of '10'.
                    """;
    private static boolean valid = true;
    final Scanner scanner = new Scanner(System.in);

    public void chooseKeyAndAction(String action) {
        while (valid) {

            System.out.println(ENTER_KEY_CONSOLE);
            try {
                String key = scanner.nextLine();
                switch (key) {
                    case "1" -> {
                        if ("1".equals(action)) {
                            encrypt(KEY_5);
                        } else decrypt(KEY_5);
                        valid = false;
                    }
                    case "2" -> {
                        if ("1".equals(action)) {
                            encrypt(KEY_7);
                        } else decrypt(KEY_7);
                        valid = false;
                    }
                    case "3" -> {
                        if ("1".equals(action)) {
                            encrypt(KEY_10);
                        } else decrypt(KEY_10);
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

    private void encrypt(int ENCRYPT_KEY) {

        char[] chars = fileConvertToChars.bytesToChars();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            if (UKR.contains(String.valueOf(originalChar)) || ENG.contains(String.valueOf(originalChar))) {

                String alphabet;
                if (UKR.contains(String.valueOf(originalChar))) {
                    // for ukrainian
                    alphabet = UKR;
                } else {
                    // for english
                    alphabet = ENG;
                }

                int index = alphabet.indexOf(originalChar);
                index = (index + ENCRYPT_KEY) % alphabet.length();  // shift index with the key

                // ensure correct case (upper or lower)
                if (Character.isUpperCase(originalChar)) {
                    chars[i] = Character.toUpperCase(alphabet.charAt(index));
                } else {
                    chars[i] = Character.toLowerCase(alphabet.charAt(index));
                }
            } else if (PUNCTUATION.contains(String.valueOf(originalChar))) {
                int index = PUNCTUATION.indexOf(originalChar);
                chars[i] = PUNCTUATION.charAt((index + ENCRYPT_KEY) % PUNCTUATION.length());
            }
        }

        byte[] encryptedBytes = fileConvertToChars.charsToBytes(chars);
        fileConvertToChars.saveFile(encryptedBytes);
    }

    private void decrypt(int DECRYPT_KEY) {

        char[] chars = fileConvertToChars.bytesToChars();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            if (UKR.contains(String.valueOf(originalChar)) || ENG.contains(String.valueOf(originalChar))) {

                String alphabet;
                if (UKR.contains(String.valueOf(originalChar))) {
                    // for ukrainian
                    alphabet = UKR;
                } else {
                    // for english
                    alphabet = ENG;
                }

                int index = alphabet.indexOf(originalChar);
                index = (index - DECRYPT_KEY + alphabet.length()) % alphabet.length();  // shift index with the key

                // ensure correct case (upper or lower)
                if (Character.isUpperCase(originalChar)) {
                    chars[i] = Character.toUpperCase(alphabet.charAt(index));
                } else {
                    chars[i] = Character.toLowerCase(alphabet.charAt(index));
                }
            } else if (PUNCTUATION.contains(String.valueOf(originalChar))) {
                int index = PUNCTUATION.indexOf(originalChar);
                chars[i] = PUNCTUATION.charAt((index - DECRYPT_KEY + PUNCTUATION.length()) % PUNCTUATION.length());
            }
        }

        byte[] decryptedBytes = fileConvertToChars.charsToBytes(chars);
        fileConvertToChars.saveFile(decryptedBytes);
    }


    public EncryptDecryptText(FileConvertToChars fileConvertToChars) {
        this.fileConvertToChars = fileConvertToChars;
    }
}
