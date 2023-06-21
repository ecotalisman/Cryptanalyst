public class DecryptText {
    private static final String UKR = Constants.UKRAINIAN_LETTERS;
    private static final String ENG = Constants.ENGLISH_LETTERS;
    private static final String PUNCTUATION = Constants.PUNCTUATION;
    private final FileOpenSaveAndConvert fileOpenSaveAndConvert;

    private void decrypt(int DECRYPT_KEY) {

        char[] chars = fileOpenSaveAndConvert.bytesToChars();

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

        byte[] decryptedBytes = fileOpenSaveAndConvert.charsToBytes(chars);
        fileOpenSaveAndConvert.saveFile(decryptedBytes);
    }

    public DecryptText(FileOpenSaveAndConvert fileOpenSaveAndConvert) {
        this.fileOpenSaveAndConvert = fileOpenSaveAndConvert;
    }
}
