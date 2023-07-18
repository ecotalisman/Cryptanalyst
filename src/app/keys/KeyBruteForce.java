package app.keys;

import app.FileOpenSaveAndConvert;
import app.menu.MenuOption;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class KeyBruteForce extends Key {
    private Key chosenKey;
    private String openFileName;

    @Override
    public void key() {
        this.openFileName = new MenuOption().openFileOption();
        var fileOpenSaveAndConvert = new FileOpenSaveAndConvert(openFileName);
        byte[] data = fileOpenSaveAndConvert.openFile();
        this.chosenKey = chosenKey(data);
    }

    public String getOpenFileName() {
        return openFileName;
    }

    @Override
    public int encryptKey() {
        return this.chosenKey.encryptKey();
    }

    @Override
    public String numberSpace() {
        return this.chosenKey.numberSpace();
    }

    protected Key chosenKey(byte[] data) {

        String dataStr = new String(data, StandardCharsets.UTF_8);

        HashMap<String, Key> keyHashMap = new HashMap<>();
        keyHashMap.put("  ", new KeyOne());
        keyHashMap.put("   ", new KeyTwo());
        keyHashMap.put("    ", new KeyThree());

        if (dataStr.contains("    ")) {
            this.chosenKey = keyHashMap.get("    ");
        } else if (dataStr.contains("   ")) {
            this.chosenKey = keyHashMap.get("   ");
        } else {
            this.chosenKey = keyHashMap.get("  ");
        }
        return this.chosenKey;
    }
}