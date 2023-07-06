package app.menu;

import app.EncryptText;
import app.FileOpenSaveAndConvert;
import app.keys.Key;

public class MenuOptionEncrypt extends MenuOption {
    @Override
    public void runApp() {
        Key key = new MenuKeyEncrypt().runKey();
        EncryptText encryptText = new EncryptText(new FileOpenSaveAndConvert(openFileOption(), saveFileOption()));
        encryptText.encrypt(key);
    }
}
