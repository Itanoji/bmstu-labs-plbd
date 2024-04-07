import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String filePath = "input.txt"; // Замените на путь к вашему текстовому файлу
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Введите длину слов для поиска: ");
        int wordLength = consoleScanner.nextInt();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            String text = scanner.useDelimiter("\\A").next(); // Читаем весь текст файла
            Pattern questionPattern = Pattern.compile("[^.!?]*\\?", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher questionMatcher = questionPattern.matcher(text);

            Set<String> uniqueWords = new HashSet<>();
            while (questionMatcher.find()) {
                String question = questionMatcher.group();
                Pattern wordPattern = Pattern.compile("\\b\\w{" + wordLength + "}\\b", Pattern.UNICODE_CHARACTER_CLASS);
                Matcher wordMatcher = wordPattern.matcher(question);

                while (wordMatcher.find()) {
                    uniqueWords.add(wordMatcher.group().toLowerCase()); // Добавляем слова в нижнем регистре для избежания дубликатов
                }
            }

            System.out.println("Уникальные слова длиной " + wordLength + " в вопросительных предложениях:");
            uniqueWords.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }

        consoleScanner.close();
    }
}
