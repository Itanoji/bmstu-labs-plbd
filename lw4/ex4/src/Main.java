import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Building building = new Theater("Дюсалей", "ул. Бауманская", new Date());
        building.build();
    }
}
