import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String sourceFilePath = "input.txt";
        String outputDirPath = "output/";
        String outputFileName = "output.txt";

        File inputFile = new File(sourceFilePath);
        File outputDir = new File(outputDirPath);

        // Создание директории для вывода, если она не существует
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        File outputFile = new File(outputDir, outputFileName);

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println(processLine(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден - " + e.getMessage());
        }
    }

    private static String processLine(String line) {
        String[] parts = line.split(" ");
        if (parts.length < 2) return line; // Если строка не содержит оценок

        double sum = 0;
        for (int i = 1; i < parts.length; i++) {
            sum += Integer.parseInt(parts[i]);
        }
        double average = sum / (parts.length - 1);

        if (average > 7) {
            return parts[0].toUpperCase() + line.substring(parts[0].length());
        } else {
            return line;
        }
    }
}
