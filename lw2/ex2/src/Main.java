import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        in.nextLine();
        System.out.println("Введите строки:");
        String result = "";
        int minCount = -1;
        for(int i = 0; i < n; i++) {
            String newStr = in.nextLine();
            int count = getUniqueCharCount(newStr);
            if(i == 0) {
                minCount = count;
                result = newStr;
            } else if(count < minCount) {
                minCount = count;
                result = newStr;
            }
        }
        System.out.println("Слово с минимальным количеством различных символов:");
        System.out.println(result);

        printInfo();

    }

    private static int getUniqueCharCount(String str) {
        return Arrays.stream(str.split(""))
                .collect(Collectors.toSet())
                .size();
    }

    private static void printInfo() {
        System.out.printf("-----------------------------\nРазработчик: Зыкин\nДата и время получения задания: 09.02.2024 13:50\nДата и время сдачи задания: %s",
                new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }
}
