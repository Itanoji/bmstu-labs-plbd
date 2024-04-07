import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String filePath = "input.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter("[.!?]"); // Разделение текста на предложения

            // Чтение и сохранение всех предложений
            String firstSentence = scanner.hasNext() ? scanner.next().trim() : null;
            StringBuilder restText = new StringBuilder();
            while (scanner.hasNext()) {
                restText.append(scanner.next());
            }

            if (firstSentence != null) {
                // Находим уникальное слово в первом предложении
                findUniqueWord(firstSentence, restText.toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }

    private static void findUniqueWord(String firstSentence, String restText) {
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher firstSentenceMatcher = wordPattern.matcher(firstSentence);
        Set<String> wordsInRestText = new HashSet<>();
        Matcher restTextMatcher = wordPattern.matcher(restText);

        // Сохраняем все слова из оставшегося текста в Set для быстрого поиска
        while (restTextMatcher.find()) {
            wordsInRestText.add(restTextMatcher.group().toLowerCase());
        }

        // Ищем уникальное слово в первом предложении
        while (firstSentenceMatcher.find()) {
            String word = firstSentenceMatcher.group().toLowerCase();
            if (!wordsInRestText.contains(word)) {
                System.out.println("Уникальное слово в первом предложении: " + word);
                return; // Выводим первое найденное уникальное слово и завершаем метод
            }
        }

        System.out.println("Уникальных слов в первом предложении не найдено.");
    }
}
