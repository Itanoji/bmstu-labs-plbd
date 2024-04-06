import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            List<VectorR3> vectors = new ArrayList<>();
            System.out.print("Введите количество векторов: ");
            int m;
            while (true) {
                try {
                    m = in.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Необходимо ввести целое число! Повторите ввод!");
                    in.next();
                }
            }

            System.out.println("Введите координаты векторов:");
            for (int i = 0; i < m; i++) {
                try {
                    double x = in.nextDouble();
                    double y = in.nextDouble();
                    double z = in.nextDouble();
                    vectors.add(new VectorR3(new double[]{x, y, z}));
                } catch (InputMismatchException e) {
                    System.out.println("Необходимо ввести 3 числа! Повторите ввод");
                    in.next();
                    i--; //Откат назад
                }
            }

            List<VectorR3[]> coplanar = findCoplanarVectors(vectors);
            System.out.println("Компланарные группы векторов:");
            for (VectorR3[] group : coplanar) {
                System.out.println("{");
                for (VectorR3 vector : group) {
                    System.out.println(Arrays.toString(vector.getComponents()));
                }
                System.out.println("}");
            }


        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти!");
        } catch (NoSuchElementException e) {
            System.out.println("Не были введены все данные!");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    // Метод для определения компланарности векторов
    public static List<VectorR3[]> findCoplanarVectors(List<VectorR3> vectors) {
        List<VectorR3[]> coplanarVectors = new ArrayList<>();

        for (int i = 0; i < vectors.size()-2; i++) {
            for(int j = i + 1; j < vectors.size()-1; j++) {
                for(int k = j + 1; k < vectors.size(); k++) {
                    if(VectorR3.isCoplanar(vectors.get(i), vectors.get(j), vectors.get(k))) {
                        VectorR3 [] group = {vectors.get(i), vectors.get(j), vectors.get(k)};
                        coplanarVectors.add(group);
                    }
                }
            }
        }

        return coplanarVectors;
    }
}
