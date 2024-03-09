public abstract class SocialBuilding implements Building {
    protected String name;
    protected String address;

    public SocialBuilding(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void build() {
        System.out.printf("Было построено здание %s на %s\n", name, address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
