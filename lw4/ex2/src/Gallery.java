import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gallery {
    List<Picture> pictures;

    public Gallery() {
        this.pictures = new ArrayList<>();
    }

    public void addPicture(String name, String author, Date date) {
        Picture picture = new Picture(name, author,date);
        this.pictures.add(picture);
    }

    public void removePicture(int i) {
        this.pictures.remove(i);
    }

    public  List<Picture> getPictures() {
        return this.pictures;
    }

    public class Picture {
        private String name;
        private String author;
        private Date date;

        public Picture(String name, String author, Date date) {
            this.name = name;
            this.author = author;
            this.date = date;
        }

        public void printInfo() {
            System.out.printf("%s, %s, дата выставки: %s", name,author, date.toString());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
