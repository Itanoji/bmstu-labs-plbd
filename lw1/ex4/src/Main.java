import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = in.nextInt();
        if(n < 1) {
            return;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Введите числа:");
        for(int i = 0; i < n; i++) {
            nums.add(in.nextInt());
        }
        System.out.println("Числа, которые делятся на 5 и на 7:");
        nums.stream().filter(num -> num % 35 == 0).forEach(System.out::println);
    }
}
