package app.menu;

import app.DecryptText;
import app.FileOpenSaveAndConvert;
import app.keys.Key;

public class MenuOptionDecrypt extends MenuOption {
    @Override
    public void runApp() {
        Key key = new MenuKeyDecrypt().runKey();
        DecryptText decryptText = new DecryptText(new FileOpenSaveAndConvert(openFileOption(), saveFileOption()));
        decryptText.decrypt(key);
    }
}
