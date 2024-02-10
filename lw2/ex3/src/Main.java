import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n = in.nextInt();
        Random r = new Random();
        int [][] a = new int[n][n];

        //заполнение массива
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = r.nextInt(-n,n);
            }
        }

        System.out.println("Исходный массив:");
        printArr(a);

        System.out.print("Введите количество позиций для сдвига k: ");
        int k = in.nextInt();

        System.out.println("Сдвиг вправо на k:");
        shiftRight(a,k);
        printArr(a);

        System.out.println("Сдвиг влево на k:");
        shiftLeft(a,k);
        printArr(a);

        System.out.println("Сдвиг вверх на k:");
        shiftUp(a,k);
        printArr(a);

        System.out.println("Сдвиг вниз на k:");
        shiftDown(a,k);
        printArr(a);

        printInfo();
    }

    private static void printArr(int [][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void shiftRight(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][(j + k) % cols] = arr[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, cols);
        }
    }

    private static void shiftLeft(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][(j - k + cols) % cols] = arr[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, cols);
        }
    }

    private static void shiftUp(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[(i - k + rows) % rows][j] = arr[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, cols);
        }
    }

    private static void shiftDown(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[(i + k) % rows][j] = arr[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, cols);
        }
    }

    private static void printInfo() {
        System.out.printf("-----------------------------\nРазработчик: Зыкин\nДата и время получения задания: 09.02.2024 13:50\nДата и время сдачи задания: %s",
                new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }
}
