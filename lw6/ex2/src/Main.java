import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> ch1 = new HashMap<>();
        Map<Integer,Integer> ch2 = new HashMap<>();

        System.out.println("Введите степень 1-го многочлена");
        int n1 = in.nextInt();
        System.out.println("Введите коэф. 1-го многочлена:");
        for (int i = 0; i <= n1; i++) {
            ch1.put(n1-i, in.nextInt());
        }

        System.out.println("Введите степень 2-го многочлена");
        int n2 = in.nextInt();
        System.out.println("Введите коэф. 2-го многочлена:");
        for (int i = 0; i <= n2; i++) {
            ch2.put(n2-i, in.nextInt());
        }

        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i <= Integer.max(n1,n2); i++) {
            res.put(i,ch1.getOrDefault(i,0) + ch2.getOrDefault(i,0));
        }
        System.out.println("Реузльтат:");
        StringBuilder sb = new StringBuilder();
        for (int i = Integer.max(n1,n2); i >= 0 ; i--) {
            sb.append(res.get(i)).append("x^").append(i);
            if(i > 0) {
                sb.append(" + ");
            }
        }

        System.out.println(sb);

    }
}
