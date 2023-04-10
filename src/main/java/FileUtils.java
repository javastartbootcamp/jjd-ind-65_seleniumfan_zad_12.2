import java.io.*;
import java.util.Scanner;

public class FileUtils {
    public static Employee[] read(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int lines = countLines(file);
            Employee[] employees = new Employee[lines];

            for (int i = 0; i < lines; i++) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                double salary = Double.parseDouble(split[4]);
                employees[i] = new Employee(split[0], split[1], split[2], split[3], salary);
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException("Nie udało się odczytać pliku: " + file.getName());
        }
    }

    public static void save(File file, String content) {
        try (
                var fileWriter = new FileWriter(file);
                var writer = new BufferedWriter(fileWriter)
        ) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Nie udało się zapisać pliku " + file.getName());
        }
    }

    private static int countLines(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        return lines;
    }
}
