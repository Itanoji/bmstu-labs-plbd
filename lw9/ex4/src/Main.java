import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строки через пробел: ");
        String input = scanner.nextLine();

        Map<Character, Character> resultMap = Stream.of(input.split("\\s+")) // Разбиение входной строки на слова
                .map(String::toCharArray) // Преобразование каждого слова в массив символов
                .flatMap(chars -> chars.length >= 2 ? Stream.of(chars) : Stream.empty()) // Преобразование массивов символов в поток символов
                .collect(Collectors.toMap(chars -> chars[0], chars -> chars[1], (existing, replacement) -> replacement, HashMap::new)); // Создание Map, где первый символ - ключ, второй - значение

        System.out.println("Результат: " + resultMap);
    }
}