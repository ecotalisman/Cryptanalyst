package app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpenSaveAndConvert {

    private String fileNameOpen;
    private String fileNameSave;

    public FileOpenSaveAndConvert() {

    }

    public FileOpenSaveAndConvert(String fileName, String fileNameSave) {
        this.fileNameOpen = fileName;
        this.fileNameSave = fileNameSave;
    }

    public char[] bytesToChars() {
        byte[] bytes = openFile();
        char[] chars = new String(bytes, StandardCharsets.UTF_8).toCharArray();
        return chars;
    }

    public byte[] charsToBytes(char[] chars) {
        String str = new String(chars);
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    public void saveFile(byte[] data) {
        try {
            if (Files.notExists(Path.of(fileNameSave))) {
                Files.createFile(Path.of(fileNameSave));
            }

            try (RandomAccessFile fileSave = new RandomAccessFile(fileNameSave, "rw");
                 FileChannel channel = fileSave.getChannel()) {

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int index = 0;
                while (index < data.length) {
                    buffer.clear();

                    while (buffer.hasRemaining() && index < data.length) {
                        buffer.put(data[index++]);
                    }

                    buffer.flip();
                    channel.write(buffer);
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to save file");
        }
    }

    public byte[] openFile() {
        try (RandomAccessFile file = new RandomAccessFile(fileNameOpen, "rw");
             FileChannel channel = file.getChannel();
             var baos = new ByteArrayOutputStream()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int endOfFile = -1;
            int value = channel.read(buffer);

            while (value != endOfFile) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    baos.write(buffer.get());
                }
                channel.write(buffer);
                buffer.clear();
                value = channel.read(buffer);
            }
            byte[] data = baos.toByteArray();
            return data;
        } catch (IOException e) {
            System.out.println("File not Found!");
            return new byte[0];
        }
    }
}
