package app.keys;

import app.FileOpenSaveAndConvert;
import app.menu.MenuOption;
import app.menu.MenuOptionDecrypt;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class KeyBruteForce extends Key {
    private Key chosenKey;

    @Override
    public void key() {
        new MenuOption().openFileOption();
        FileOpenSaveAndConvert fileOpenSaveAndConvert = new FileOpenSaveAndConvert();
        byte[] data = fileOpenSaveAndConvert.openFile();
        this.chosenKey = chosenKey(data);
    }

    @Override
    public int encryptKey() {
        if (this.chosenKey == null) {
            throw new IllegalStateException("Key Number has not been chosen yet");
        }
        return this.chosenKey.encryptKey();
    }

    @Override
    public String numberSpace() {
        if (this.chosenKey == null) {
            throw new IllegalStateException("Key Space has not been chosen yet");
        }
        return this.chosenKey.numberSpace();
    }

    protected Key chosenKey(byte[] data) {

        String dataStr = new String(data, StandardCharsets.UTF_8);

        HashMap<String, Key> keyHashMap = new HashMap<>();
        keyHashMap.put("  ", new KeyOne());
        keyHashMap.put("   ", new KeyTwo());
        keyHashMap.put("    ", new KeyThree());
        Key key;
        if (dataStr.contains("    ")) {
            key = keyHashMap.get("    ");
        } else if (dataStr.contains("   ")) {
            key = keyHashMap.get("   ");
        } else {
            key = keyHashMap.get("  ");
        }
        return key;
    }
}
