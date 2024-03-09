import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Gallery gallery = new Gallery();
        gallery.addPicture("Чёрный квадрат", "Малевич", new Date());
        gallery.getPictures().get(0).printInfo();
    }
}
