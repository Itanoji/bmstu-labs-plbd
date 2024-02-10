import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        in.nextLine();
        System.out.println("Введите строки:");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(in.nextLine());
        }
        System.out.println("Отсортированные строки в порядке возрастания значений их длины");
        strings.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
        System.out.println("Отсортированные строки в порядке убывания значений их длины");
        strings.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::println);
        printInfo();

    }

    private static void printInfo() {
        System.out.printf("-----------------------------\nРазработчик: Зыкин\nДата и время получения задания: 09.02.2024 13:50\nДата и время сдачи задания: %s",
                new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }
}
