import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employer> employers = new ArrayList<>();
        employers.add(new Engineer("Вася"));
        employers.add(new Manager("Петя", new Date()));

        employers.forEach(Employer::work);

    }
}
