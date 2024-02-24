public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.addDoor(new Door());
        house.addDoor(new Door());
        house.addWindow(new Window());
        house.open();
        house.lock();
        house.printDoorsCount();
        house.printWindowsCount();

    }
}
