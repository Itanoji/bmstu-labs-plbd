import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String filePath = "input.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                findAndPrintWordsStartingWithVowel(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    private static void findAndPrintWordsStartingWithVowel(String line) {
        // Добавляем русские гласные к английским
        String vowels = "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ";
        // Разбиваем строку на слова
        String[] words = line.split("\\s+|,\\s*|\\.\\s*"); // Делим по пробелам, запятым и точкам
        for (String word : words) {
            if (!word.isEmpty() && vowels.indexOf(word.charAt(0)) != -1) {
                System.out.println(word);
            }
        }
    }
}
