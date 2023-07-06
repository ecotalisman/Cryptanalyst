package app.menu;

import app.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

import static app.menu.MenuConstants.*;

public class MenuOption {

    public void runApp() {
        System.out.println("Choose menu key:");
    }
    public String openFileOption() {
        Scanner scannerPathOpen = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Enter the file path to OPEN:");
            String path = scannerPathOpen.nextLine();

            try {
                if (Files.exists(Path.of(path))) {
                    isRunning = false;
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

    protected String saveFileOption() {
        Scanner scannerPathSave = new Scanner(System.in);
        System.out.println("Enter the file path to SAVE:");
        String path = scannerPathSave.nextLine();
        return path;
    }
}
