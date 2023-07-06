package app;

import app.keys.Key;

import java.util.ArrayList;
import java.util.List;

public class EncryptText {
    private static final String UKR = Constants.UKRAINIAN_LETTERS;
    private static final String ENG = Constants.ENGLISH_LETTERS;
    private static final String PUNCTUATION = Constants.PUNCTUATION;
    private final FileOpenSaveAndConvert fileOpenSaveAndConvert;

    public void encrypt(Key key) {

        char[] chars = fileOpenSaveAndConvert.bytesToChars();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            if (UKR.contains(String.valueOf(originalChar)) || ENG.contains(String.valueOf(originalChar))) {

                String alphabet;
                if (UKR.contains(String.valueOf(originalChar))) {
                    alphabet = UKR;
                } else {
                    alphabet = ENG;
                }

                int index = alphabet.indexOf(originalChar);
                index = (index + key.encryptKey()) % alphabet.length();

                if (Character.isUpperCase(originalChar)) {
                    chars[i] = Character.toUpperCase(alphabet.charAt(index));
                } else {
                    chars[i] = Character.toLowerCase(alphabet.charAt(index));
                }
            } else if (PUNCTUATION.contains(String.valueOf(originalChar))) {
                int index = PUNCTUATION.indexOf(originalChar);
                chars[i] = PUNCTUATION.charAt((index + key.encryptKey()) % PUNCTUATION.length());
            }
        }

        chars = convertAndAddSpace(chars, key);

        byte[] encryptedBytes = fileOpenSaveAndConvert.charsToBytes(chars);
        fileOpenSaveAndConvert.saveFile(encryptedBytes);
    }

    private char[] convertAndAddSpace(char[] chars, Key key) {

        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }

        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == ' ') {
                charList.remove(i);
                for (char replacement : key.numberSpace().toCharArray()) {
                    charList.add(i, replacement);
                    i++;
                }
            }
        }

        char[] result = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            result[i] = charList.get(i);
        }
        return result;
    }

    public EncryptText(FileOpenSaveAndConvert fileOpenSaveAndConvert) {
        this.fileOpenSaveAndConvert = fileOpenSaveAndConvert;
    }
}
