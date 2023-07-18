package app.keys;

public class KeyOne extends Key {
    @Override
    public int encryptKey() {
        return 4;
    }

    @Override
    public String numberSpace() {
        return "  ";
    }
}
