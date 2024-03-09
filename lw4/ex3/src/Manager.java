import java.util.Date;

public class Manager extends Engineer {
    private Date date;
    public Manager(String name, Date date) {
        super(name);
        this.date = date;
    }

    @Override
    public void work() {
        super.work();
        System.out.printf("%s руководит начиная с %s\n", name, date.toString());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
