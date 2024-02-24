import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Abiturient ab1 = new Abiturient(0,"A","B","C","Москва", "2", new int[]{3,3,4,5,5,5});
        Abiturient ab2 = new Abiturient(1,"cvcvxc","cvc","sas","sdfasff", "2", new int[]{4,3,5,5,5,5});
        Abiturient ab3 = new Abiturient(2,"nncx","zxxvc","SAAD","VCXVXC", "SAS", new int[]{5,5,5,5,4,4});
        Abiturient ab4 = new Abiturient(3,"cvx","nvc","adfaf","sdfasff", "2", new int[]{3,3,2,4,4,4});
        Abiturient ab5 = new Abiturient(4,"asdaf","vbv","rtt","sdfasff", "2", new int[]{4,3,3,2,4});

        List<Abiturient> abits = Arrays.asList(ab1,ab2,ab3,ab4,ab5);

        System.out.println("Введите проходной:");
        Scanner in = new Scanner(System.in);
        double pr = in.nextDouble();
        System.out.println("Абитуриенты, у которых есть плохие оценки:");
        findBad(abits).stream().map(Abiturient::toString).forEach(System.out::println);
        System.out.println("Абитуриенты со средним выше " + pr + ":");
        findHigherPr(abits, pr).stream().map(Abiturient::toString).forEach(System.out::println);
        System.out.println("Введите количество:");
        int count = in.nextInt();
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
                .limit(abiturients.size() - n)
                .filter(a->a.getAvg() >= pr)
                .collect(Collectors.toList());
    }

}
