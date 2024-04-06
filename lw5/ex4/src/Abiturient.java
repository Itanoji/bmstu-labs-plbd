import java.util.Arrays;
import java.util.Comparator;

public class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private int[] grades;

    public Abiturient(int id, String lastName, String firstName, String patronymic,
                      String address, String phoneNumber, int[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + ", средний балл: " +getAvg();
    }

    public double getAvg() {
        return Arrays.stream(grades).average().orElse(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
}
