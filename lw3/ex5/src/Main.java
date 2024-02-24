import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите дробь 1:");
        Drob drob1 = new Drob(new Chislo(in.nextInt()), new Chislo(in.nextInt()));
        System.out.println("Введите дробь 2:");
        Drob drob2 = new Drob(new Chislo(in.nextInt()), new Chislo(in.nextInt()));

        System.out.println("Сложение:");
        System.out.println(drob1.add(drob2));
        System.out.println("Вычитание");
        System.out.println(drob1.sub(drob2));
        System.out.println("Умножение:");
        System.out.println(drob1.mult(drob2));
        System.out.println("Деление:");
        System.out.println(drob1.div(drob2));
    }
}
