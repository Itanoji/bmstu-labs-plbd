import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Введите количество символов для отображения: ");
        int n = consoleScanner.nextInt();
        consoleScanner.nextLine(); // Очистка буфера после чтения числа

        String filePath = "input.txt";

        Map<Character, Integer> charCounts = new HashMap<>();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                for (char c : line.toCharArray()) {
                    charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }

        // Сортируем символы по количеству их встречаемости и выводим первые n
        charCounts.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .limit(n)
                .forEach(entry -> System.out.println("'" + entry.getKey() + "' встречается " + entry.getValue() + " раз(а)"));

        consoleScanner.close();
    }
}
