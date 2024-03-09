public class Engineer implements Employer {
    protected String name;

    public Engineer(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.printf("Инженер %s работает за на предприятии\n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
