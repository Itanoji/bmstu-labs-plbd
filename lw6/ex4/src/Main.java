import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

class Item {
    String name;
    int code;

    Item(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

public class Main {

    public static void main(String[] args) {
        String filePath = "input.txt"; // Замените на ваш путь к файлу
        List<Item> items = new ArrayList<>();

        // Чтение и создание списка объектов
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                items.add(new Item(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }

        items.sort(Comparator.comparingInt(item -> item.code));

        // Вывод исходного списка
        System.out.println("Исходный список:");
        items.forEach(item -> System.out.println("Name: " + item.name + ", Code: " + item.code));

        // Удаление дубликатов по наименованию, сохраняя первое вхождение
        List<Item> compressedList = new ArrayList<>();
        items.stream()
                .filter(item -> compressedList.stream().noneMatch(it -> it.name.equals(item.name)))
                .forEach(compressedList::add);

        // Вывод сжатого списка
        System.out.println("\nСжатый список:");
        compressedList.forEach(item -> System.out.println("Name: " + item.name + ", Code: " + item.code));
    }
}
