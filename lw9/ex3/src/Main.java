import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class People {
        private final String name;
        private final int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Ivan", 16),
                new People("Petr", 23),
                new People("Maria", 42)
        );

        List<People> sortedByAge = peoples.stream()
                .sorted(Comparator.comparingInt(People::getAge))
                .toList();

        sortedByAge.forEach(p -> System.out.println(p.getName() + ": " + p.getAge()));
    }
}
