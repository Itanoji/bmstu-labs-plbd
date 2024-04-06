import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String sourceFilePath = "Test.java"; // Замените на путь к исходному файлу с Java-программой
        String outputDirPath = "output/"; // Замените на путь к директории для вывода
        String outputFileName = "Test.java";

        File sourceFile = new File(sourceFilePath);
        File outputDir = new File(outputDirPath);

        // Создаем директорию, если она еще не существует
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        File outputFile = new File(outputDir, outputFileName);

        try (Scanner scanner = new Scanner(sourceFile);
             PrintWriter writer = new PrintWriter(outputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println(processLine(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    private static String processLine(String line) {
        StringBuilder processedLine = new StringBuilder();
        StringBuilder wordBuffer = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (Character.isLetter(ch)) {
                wordBuffer.append(ch);
            } else {
                if (wordBuffer.length() > 2) {
                    processedLine.append(wordBuffer.toString().toUpperCase());
                } else {
                    processedLine.append(wordBuffer.toString());
                }
                wordBuffer.setLength(0); // Очищаем буфер
                processedLine.append(ch); // Добавляем не-буквенный символ
            }
        }

        // Обработка последнего слова в строке, если оно существует
        if (wordBuffer.length() > 2) {
            processedLine.append(wordBuffer.toString().toUpperCase());
        } else {
            processedLine.append(wordBuffer.toString());
        }

        return processedLine.toString();
    }
}
