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
        int sum = 0;
        for(int i = 0; i < n; i++) {
            strings.add(in.nextLine());
            sum += strings.get(i).length();
        }
        int avg = sum/n;
        System.out.println("Средняя длина строк: " + avg);
        System.out.println("Строки, с длиной больше средней: ");
        strings.stream().filter(s-> s.length() > avg).forEach(s-> System.out.printf("%s : %d\n", s, s.length()));
        System.out.println("Строки, с длиной меньше средней: ");
        strings.stream().filter(s-> s.length() < avg).forEach(s-> System.out.printf("%s - %d\n", s, s.length()));
        printInfo();

    }

    private static void printInfo() {
        System.out.printf("-----------------------------\nРазработчик: Зыкин\nДата и время получения задания: 09.02.2024 13:50\nДата и время сдачи задания: %s",
                new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }
}
