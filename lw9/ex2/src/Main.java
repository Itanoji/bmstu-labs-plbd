import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа через пробел: ");
        String input = scanner.nextLine();

        List<Integer> numbers = parseInput(input);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("Четные числа: " + evenNumbers);
        System.out.println("Нечетные числа: " + oddNumbers);
    }

    private static List<Integer> parseInput(String input) {
        // Разбиение входной строки на числа
        return Stream.of(input.split("\\s+"))
                .map(Integer::parseInt) // Преобразование строк в целые числа
                .collect(Collectors.toList());
    }
}
