import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int m;
            System.out.println("Введите количество матриц");
            while (true) {
                try {
                    m = in.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите целое число.");
                    in.next();
                }
            }

            Matrix[] matrices = new Matrix[m];
            for (int i = 0; i < m; i++) {
                try {
                    System.out.println("Введите размерность матрицы " + (i + 1) + ":");
                    int n = in.nextInt();
                    System.out.println("Введите матрицу");
                    double[][] arr = new double[n][n];
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            arr[j][k] = in.nextDouble();
                        }
                    }
                    Matrix matrix = new Matrix(n, arr);
                    matrices[i] = matrix;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода! Введите матрицу заново");
                    in.next();
                    i--;
                }
            }


            double minNorm1 = matrices[0].calculateFirstNorm();
            double minNorm2 = matrices[0].calculateSecondNorm();
            int minNorm1Ind = 0;
            int minNorm2Ind = 0;

            for (int i = 1; i < m; i++) {
                double norm1 = matrices[i].calculateFirstNorm();
                double norm2 = matrices[i].calculateSecondNorm();
                if (norm1 < minNorm1) {
                    minNorm1 = norm1;
                    minNorm1Ind = i;
                }
                if (norm2 < minNorm2) {
                    minNorm2 = norm2;
                    minNorm2Ind = i;
                }
            }
            System.out.println("Матрица с минимальной первой нормой:");
            System.out.println(matrices[minNorm1Ind].toString());
            System.out.println("Матрица с минимальной второй нормой:");
            System.out.println(matrices[minNorm2Ind].toString());
        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти");
        } catch (NoSuchElementException e) {
            System.out.println("Не все данные введены");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

    }
}
