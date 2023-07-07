package app.menu;

import app.DecryptText;
import app.FileOpenSaveAndConvert;
import app.keys.Key;
import app.keys.KeyBruteForce;

public class MenuOptionDecrypt extends MenuOption {
    @Override
    public void runApp() {
        Key key = new MenuKeyDecrypt().runKey();
        DecryptText decryptText;
        if (key instanceof KeyBruteForce ) {
            decryptText = new DecryptText(new FileOpenSaveAndConvert(((KeyBruteForce) key).getOpenFileName(), saveFileOption()));
        } else {
            decryptText = new DecryptText(new FileOpenSaveAndConvert(openFileOption(), saveFileOption()));
        }
        decryptText.decrypt(key);
    }
}
