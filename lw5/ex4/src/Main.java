import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во абитуриентов:");
        List<Abiturient> abits = new ArrayList<>();
        int n;
        while (true) {
            try {
                n = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода, повторите!");
                in.next();
            }
        }
        for(int i = 0; i < n; i++) {
            try {
                System.out.println("Введите данные абитуриента:");
                String last = in.nextLine();
                String first = in.nextLine();
                String patr = in.nextLine();
                String address = in.nextLine();
                String phone = in.nextLine();
                int[] scores = new int[6];
                for(int j = 0; j < 6; j++) {
                    scores[j] = in.nextInt();
                }
                Abiturient a = new Abiturient(i,last, first, patr, address, phone, scores);
                abits.add(a);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Введите абитуриента повторно");
                in.next();
                i--;
            }

        }


        System.out.println("Введите проходной:");
        double pr;
        while (true) {
            try {
                pr = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Повторите!");
                in.next();
            }
        }
        System.out.println("Абитуриенты, у которых есть плохие оценки:");
        findBad(abits).stream().map(Abiturient::toString).forEach(System.out::println);
        System.out.println("Абитуриенты со средним выше " + pr + ":");
        findHigherPr(abits, pr).stream().map(Abiturient::toString).forEach(System.out::println);
        System.out.println("Введите количество:");
        int count;
        while (true) {
            try {
                count = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Повторите!");
                in.next();
            }
        }
        System.out.println("Абитуриенты в топ " + count + ":");
        findTopN(abits, count).stream().map(Abiturient::toString).forEach(System.out::println);
        System.out.println("Список абитуриентов с полупроходным:");
        findPoluprohod(abits,count,pr).stream().map(Abiturient::toString).forEach(System.out::println);

    }

    public static List<Abiturient> findBad(List<Abiturient> abiturients) {
       return abiturients.stream().filter(a -> Arrays.stream(a.getGrades()).anyMatch(g-> g == 2)).collect(Collectors.toList());
    }

    public static List<Abiturient> findHigherPr(List<Abiturient> abiturients, double pr) {
       return abiturients.stream().filter(a -> a.getAvg() > pr).collect(Collectors.toList());
    }

    public static List<Abiturient> findTopN(List<Abiturient> abiturients, int n) {
        return abiturients.stream()
                .sorted(Comparator.comparingDouble(Abiturient::getAvg).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    //Пусть студенты с полупроходным - те, кто не попали в топ n, но имеют выше проходного
    public static List<Abiturient> findPoluprohod(List<Abiturient> abiturients, int n, double pr) {
        return abiturients.stream()
                .sorted(Comparator.comparingDouble(Abiturient::getAvg))
                .limit(abiturients.size() - n > 0?abiturients.size() - n : abiturients.size() )
                .filter(a->a.getAvg() >= pr)
                .collect(Collectors.toList());
    }

}
