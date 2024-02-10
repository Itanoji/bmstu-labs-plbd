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

        int maxUp = 0;
        int currCountUp = 1;
        int maxDown = 0;
        int currCountDown = 1;
        int prev = a[0][0]; //первый элемент можно не пропускать, так как нужно строгое убывание/возрастание
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //возрастание
                if (a[i][j] > prev) {
                    currCountUp++;
                } else {
                    if(currCountUp > maxUp) maxUp = currCountUp;
                    currCountUp = 1;
                }

                //убывание
                if (a[i][j] < prev) {
                   currCountDown++;
                } else {
                    if(currCountDown > maxDown) maxDown = currCountDown;
                    currCountDown = 1;
                }
                prev = a[i][j];
            }
        }

        //отдельно проверяем после последнего элемента, если там была последовательность
        if(currCountDown > maxDown) maxDown = currCountDown;
        if(currCountUp > maxUp) maxUp = currCountUp;

        System.out.printf("Наибольшее число возрастающих элементов матриц, идущих подряд: %d.\n", maxUp);
        System.out.printf("Наибольшее число убывающих элементов матриц, идущих подряд: %d.\n", maxDown);

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


    private static void printInfo() {
        System.out.printf("-----------------------------\nРазработчик: Зыкин\nДата и время получения задания: 09.02.2024 13:50\nДата и время сдачи задания: %s",
                new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }
}
