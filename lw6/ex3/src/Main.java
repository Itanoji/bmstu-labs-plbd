import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = this;
    }
}

public class Main {

    private static List<ListNode> readMatrixAndCreateList(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        List<ListNode> nodes = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            for (String valueStr : currentLine) {
                int value = Integer.parseInt(valueStr);
                if (value != 0) { // Добавляем только ненулевые элементы
                    nodes.add(new ListNode(value));
                }
            }
        }
        scanner.close();

        // Создаем циклический связный список
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        if (!nodes.isEmpty()) {
            nodes.get(nodes.size() - 1).next = nodes.get(0); // Замыкаем цикл
        }

        return nodes;
    }

    private static void processLists(List<ListNode> listA, List<ListNode> listB) {
        List<Integer> sums = new ArrayList<>();
        List<Integer> products = new ArrayList<>();

        for (int i = 0; i < Math.min(listA.size(), listB.size()); i++) {
            int sum = listA.get(i).value + listB.get(i).value;
            int product = listA.get(i).value * listB.get(i).value;
            sums.add(sum);
            products.add(product);
        }

        System.out.println("Попарные суммы:");
        sums.forEach(System.out::println);

        System.out.println("Попарные произведения:");
        products.forEach(System.out::println);
    }

    public static void main(String[] args) {
        try {
            List<ListNode> listA = readMatrixAndCreateList("matrixA.txt");
            List<ListNode> listB = readMatrixAndCreateList("matrixB.txt");
            processLists(listA, listB);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
