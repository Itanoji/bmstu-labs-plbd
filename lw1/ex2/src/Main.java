import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество строк для вывода:");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String str = "Строка для вывода";
        System.out.println("Вывод с переходом на новую строку:");
        int i = 0;
        while(i++ < count) {
            System.out.println(str);
        }
        System.out.println("Вывод без перехода на новую строку:");
        i = 0;
        while(i++ < count) {
            System.out.print(str);
        }
    }
}