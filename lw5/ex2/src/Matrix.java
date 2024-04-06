import java.util.Arrays;

public class Matrix {
    private int n;
    private double[][] elements;

    // Конструктор для инициализации матрицы нулями
    public Matrix(int n) {
        this.n = n;
        this.elements = new double[n][n];
    }

    // Конструктор для инициализации матрицы заданными значениями
    public Matrix(int n, double[][] elements) {
        this.n = n;
        this.elements = Arrays.copyOf(elements, n);
    }

    // Конструктор для инициализации матрицы другой матрицей
    public Matrix(Matrix matrix) {
        this.n = matrix.getN();
        this.elements = Arrays.copyOf(matrix.getElements(), matrix.getN());
    }

    // Метод для сложения матриц
    public Matrix add(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }

        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.elements[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }
        return result;
    }

    // Метод для вычитания матриц
    public Matrix subtract(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }

        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.elements[i][j] = this.elements[i][j] - other.elements[i][j];
            }
        }
        return result;
    }

    // Метод для умножения матриц
    public Matrix multiply(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }

        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result.elements[i][j] += this.elements[i][k] * other.elements[k][j];
                }
            }
        }
        return result;
    }

    // Метод для вычисления первой нормы матрицы
    public double calculateFirstNorm() {
        double norm = 0;
        for (int j = 0; j < n; j++) {
            double columnSum = 0;
            for (int i = 0; i < n; i++) {
                columnSum += Math.abs(elements[i][j]);
            }
            norm = Math.max(norm, columnSum);
        }
        return norm;
    }

    // Метод для вычисления второй нормы матрицы
    public double calculateSecondNorm() {
        double norm = 0;
        for (int i = 0; i < n; i++) {
            double rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += Math.abs(elements[i][j]);
            }
            norm = Math.max(norm, rowSum);
        }
        return norm;
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixString.append(elements[i][j]).append(" ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[][] getElements() {
        return elements;
    }

    public void setElements(double[][] elements) {
        this.elements = elements;
    }
}
