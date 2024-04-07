import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину слов для замены: ");
        int wordLength = in.nextInt();
        in.nextLine(); // Очистка буфера после чтения числа

        System.out.print("Введите подстроку для замены: ");
        String replacement = in.nextLine();

        String sourceFilePath = "input.txt"; // Замените на ваш путь к исходному файлу
        String outputFilePath = "output.txt"; // Замените на ваш путь к выходному файлу

        // Создаем шаблон для поиска слов заданной длины
        Pattern pattern = Pattern.compile("\\b\\w{" + wordLength + "}\\b", Pattern.UNICODE_CHARACTER_CLASS);

        try (Scanner fileScanner = new Scanner(new File(sourceFilePath));
             PrintWriter writer = new PrintWriter(outputFilePath)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                String modifiedLine = matcher.replaceAll(replacement);
                writer.println(modifiedLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }

        in.close();
    }
}
