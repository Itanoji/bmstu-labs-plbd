import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class House {
    private List<Window> windows;
    private List<Door> doors;
    private boolean locked;

    public House() {
        this.windows = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.locked = false;
    }
    public House(ArrayList<Window> windows, ArrayList<Door> doors) {
        this.windows = windows;
        this.doors = doors;
        this.locked = false;
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public void lock() {
        locked = true;
        System.out.println("Дом был закрыт.");
    }

    public void open() {
        locked = false;
        System.out.println("Дом был открыт.");
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void printWindowsCount() {
        System.out.println("Количество окон: " + windows.size());
    }

    public void printDoorsCount() {
        System.out.println("Количетво дверей: " + doors.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return locked == house.locked && Objects.equals(windows, house.windows) && Objects.equals(doors, house.doors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windows.size(), doors.size(), locked);
    }

    @Override
    public String toString() {
        return "Количество окон: " + windows.size()
                + ", количество дверей: "
                + doors.size() + ", "
                + (locked? "закрыт." : "открыт.");
    }
}