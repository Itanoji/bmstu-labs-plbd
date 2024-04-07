import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern VOWELS_PATTERN = Pattern.compile("[aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ]");
    private static final Pattern CONSONANTS_PATTERN = Pattern.compile("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZбвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ]");

    public static void main(String[] args) {
        String filePath = "input.txt"; // Замените на путь к вашему текстовому файлу

        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter("[.!?]"); // Разделение текста на предложения

            while (scanner.hasNext()) {
                String sentence = scanner.next();
                Matcher vowelsMatcher = VOWELS_PATTERN.matcher(sentence);
                Matcher consonantsMatcher = CONSONANTS_PATTERN.matcher(sentence);

                int vowelsCount = 0;
                while (vowelsMatcher.find()) {
                    vowelsCount++;
                }

                int consonantsCount = 0;
                while (consonantsMatcher.find()) {
                    consonantsCount++;
                }

                if (vowelsCount > consonantsCount) {
                    System.out.println("В предложении больше гласных: " + sentence.trim());
                } else if (consonantsCount > vowelsCount) {
                    System.out.println("В предложении больше согласных: " + sentence.trim());
                } else {
                    System.out.println("Гласных и согласных поровну: " + sentence.trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
