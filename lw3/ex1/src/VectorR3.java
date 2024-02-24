import java.util.Arrays;

public class VectorR3 {
    private double [] components;

    public VectorR3(double [] components) {
        if (components.length != 3) {
            throw new RuntimeException("Incorrect vector size");
        }
        this.components = components;
    }

    // Метод для проверки ортогональности векторов
    public boolean isOrthogonal(VectorR3 other) {
        double dotProduct = 0;
        for (int i = 0; i < components.length; i++) {
            dotProduct += components[i] * other.components[i];
        }
        return dotProduct == 0;
    }

    // Метод для проверки пересечения не ортогональных векторов
    public boolean isIntersecting(VectorR3 other) {
        return !isOrthogonal(other);
    }

    // Метод для сравнения векторов
    public boolean isEqual(VectorR3 other) {
        return Arrays.equals(components, other.components);
    }

    // Метод для определения компланарности векторов
    public boolean isCoplanar(VectorR3 v2, VectorR3 v3) {
        double[][] matrix = {
                {components[0], components[1], components[2]},
                {v2.components[0], v2.components[1], v2.components[2]},
                {v3.components[0], v3.components[1], v3.components[2]}
        };

        double determinant = calculateDeterminant(matrix);
        return determinant == 0;
    }

    // Метод для определения компланарности векторов
    public static boolean isCoplanar(VectorR3 v1, VectorR3 v2, VectorR3 v3) {
        double[][] matrix = {
                {v1.components[0], v1.components[1], v1.components[2]},
                {v2.components[0], v2.components[1], v2.components[2]},
                {v3.components[0], v3.components[1], v3.components[2]}
        };

        double determinant = calculateDeterminant(matrix);
        return determinant == 0;
    }

    private static double calculateDeterminant(double[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }
}
