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

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int indFirst = -1, indSecond = -1;
            for(int j = 0; j < n; j++) {
                if(a[i][j] > 0) {
                    if(indFirst == - 1) {
                        indFirst = j;
                    } else {
                        indSecond = j;
                        for(int k = indFirst+1; k < indSecond; k++) {
                            sum += a[i][k];
                        }
                        break; //нет смысла дальше идти по строке
                    }
                }
            }
        }

        System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки:");
        System.out.println(sum);

        printInfo();
    }

    private static void printArr(int [][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for(int i = 0; i < rows; i++) {
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
