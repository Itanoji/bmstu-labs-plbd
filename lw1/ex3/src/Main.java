import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = in.nextInt();
        if(n < 1) {
            return;
        }
        int [] nums = new int[n];
        System.out.println("Введите числа:");
        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        System.out.printf("Максимальное число: %d, минимальное число: %d.", max, min);
    }
}
