import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class Filee {
    private String name;
    private String directory;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void create() throws FileNotFoundException {
        Formatter path = new Formatter();
        path.format("C:\\%s\\%s", directory, name);

        byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
        long startTime = System.currentTimeMillis();

        try (FileOutputStream outputStream = new FileOutputStream(String.valueOf(path))) {
            outputStream.write(buffer);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }

        long endTime = System.currentTimeMillis();
        File file = new File(String.valueOf(path));
        long fileSize = file.length();

        System.out.println("Текст успешно записан");
        System.out.format("Размер файла - %d байт%nВремя записи - %d мс%n", fileSize, endTime - startTime);
    }

    public void update() {
        Formatter path = new Formatter();
        path.format("C:\\%s\\%s", directory, name);

        byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
        try (FileOutputStream outputStream = new FileOutputStream(String.valueOf(path), false)) {
            outputStream.write(buffer);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
        System.out.println("Текст успешно обновлен");
    }

    public void search() throws IOException {
        Formatter path = new Formatter();
        path.format("C:\\%s\\%s", directory, name);

        try {
            String content = new String(Files.readAllBytes(Paths.get(String.valueOf(path))));
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
