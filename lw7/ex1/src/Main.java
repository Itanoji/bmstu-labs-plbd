import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String sourceFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Шаблон для поиска ошибок с учетом регистра и условия не быть в конце слова
        Pattern pattern = Pattern.compile("РА(?=\\w)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

        try (Scanner scanner = new Scanner(new File(sourceFilePath));
             PrintWriter writer = new PrintWriter(outputFilePath)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                // Замена "РА" на "РО" или "ра" на "ро", сохраняя регистр и следующую букву
                String correctedLine = matcher.replaceAll(result ->
                        result.group().startsWith("Р") || result.group().startsWith("р") ? "ро" : "РО");
                writer.println(correctedLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
