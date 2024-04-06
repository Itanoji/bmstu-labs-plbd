import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "input.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            StringBuilder contentBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine()).append(" ");
            }
            String content = contentBuilder.toString();
            findAndPrintMatchingWords(content);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    private static void findAndPrintMatchingWords(String content) {
        // Удаляем знаки препинания для упрощения разбиения на слова
        String[] words = content.replaceAll("[,.]", "").split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            if (!currentWord.isEmpty() && !nextWord.isEmpty() &&
                    currentWord.charAt(currentWord.length() - 1) == nextWord.charAt(0)) {
                System.out.println(currentWord + " " + nextWord);
            }
        }
    }
}
