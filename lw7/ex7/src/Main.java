import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int countVowels(String word) {
        int vowels = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiouаеёиоуыэюя".indexOf(c) != -1) {
                vowels++;
            }
        }
        return vowels;
    }

    public static void main(String[] args) {
        String filePath = "input.txt";

        List<String> words = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = wordPattern.matcher(line);
                while (matcher.find()) {
                    words.add(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }

        words.sort(Comparator.comparingInt(Main::countVowels)
                .thenComparingInt(String::length).reversed()
                .thenComparing(Comparator.naturalOrder()));

        words.forEach(System.out::println);
    }
}
