import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Введите начальный символ подстроки: ");
        char startSymbol = consoleScanner.next().charAt(0);
        System.out.print("Введите конечный символ подстроки: ");
        char endSymbol = consoleScanner.next().charAt(0);

        String filePath = "input.txt";

        StringBuilder text = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            fileScanner.useDelimiter("\\A"); // Читаем весь файл как одну строку
            if (fileScanner.hasNext()) {
                text.append(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            consoleScanner.close();
            return;
        }

        String regex = Pattern.quote(String.valueOf(startSymbol)) + ".*?" + Pattern.quote(String.valueOf(endSymbol));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String longestSubstring = "";
        int longestStart = -1;
        int longestEnd = -1;

        String max = "";
        while (matcher.find()) {
            String currentMatch = matcher.group();
            if (currentMatch.length() > longestSubstring.length()) {
                max = currentMatch;
                longestSubstring = currentMatch;
                longestStart = matcher.start();
                longestEnd = matcher.end();
            }
        }

        System.out.println("Удалена подстрока: " + max);
        if (longestStart != -1 && longestEnd != -1) {
            text.delete(longestStart, longestEnd);
        }

        System.out.println(text.toString());
        consoleScanner.close();
    }
}
