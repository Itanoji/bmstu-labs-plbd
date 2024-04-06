import java.util.StringJoiner;

public class Patient {
    private long id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String address;
    private String phone;
    private long cardNumber;
    private String diagnose;

    public Patient(long id, String firstName, String secondName, String patronymic, String address, String phone, long cardNumber, String diagnose) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return secondName + " " + firstName + " " + patronymic + ", " + cardNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}