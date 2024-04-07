import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new LinkedHashSet<>();
        System.out.println("Введите размер ряда");
        int n = in.nextInt();
        System.out.println("Введите числа ряда");
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        System.out.println("Результат: " + sumPairs(set));


    }

    public static Set<Integer> sumPairs(Set<Integer> set) {
        if (set.size() < 2) {
            return set;
        }
        Set<Integer> pairs = new LinkedHashSet<>();
        for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
            Integer p1 = it.next();
            if (it.hasNext()) {
                p1 += it.next();
            }
            pairs.add(p1);
        }
        return sumPairs(pairs);
    }
}
