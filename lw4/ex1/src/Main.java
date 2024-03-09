public class Main {
    public static void main(String[] args) {
        Mobile mobile = new Mobile("Redmi 9", 8, "i5", 32);
        Mobile.Model model = mobile.getModel();
        System.out.println(model.getName());
    }
}
