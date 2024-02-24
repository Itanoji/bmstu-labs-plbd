public class Main {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix(3, new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix matrixB = new Matrix(3, new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        Matrix matrixC = new Matrix(3, new double[][]{{3, 5, 3}, {2, 1, 0}, {6, 3, 8}});
        Matrix matrixD = new Matrix(3, new double[][]{{0, 5, 4}, {4, 7, 1}, {2, 8, 0}});

        Matrix[] matrices = new Matrix[4];
        matrices[0] = matrixA;
        matrices[1] = matrixB;
        matrices[2] = matrixC;
        matrices[3] = matrixD;

        double minNorm1 = matrices[0].calculateFirstNorm();
        double minNorm2 = matrices[0].calculateSecondNorm();
        int minNorm1Ind = 0;
        int minNorm2Ind = 0;

        for (int i = 1; i < 4; i++) {
            double norm1 = matrices[i].calculateFirstNorm();
            double norm2 = matrices[i].calculateSecondNorm();
            if(norm1 < minNorm1) {
                minNorm1 = norm1;
                minNorm1Ind = i;
            }
            if(norm2 < minNorm2) {
                minNorm2 = norm2;
                minNorm2Ind = i;
            }
        }
        System.out.println("Матрица с минимальной первой нормой:");
        System.out.println(matrices[minNorm1Ind].toString());
        System.out.println("Матрица с минимальной второй нормой:");
        System.out.println(matrices[minNorm2Ind].toString());
    }
}
