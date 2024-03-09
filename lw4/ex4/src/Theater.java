import java.util.Date;

public class Theater extends SocialBuilding {
    private Date date;

    public Theater(String name, String address, Date date) {
        super(name, address);
        this.date = date;
    }

    @Override
    public void build() {
        super.build();
        System.out.printf("Выступление в %s будет %s\n", name, date.toString());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
