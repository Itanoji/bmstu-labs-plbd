public class Main {
    final static String PASSWORD = "aboba 2323";

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Пароль не введён!");
            return;
        }

        //Пароль может включать пробелы
        String password = String.join(" ", args);
        if(password.equals(PASSWORD)) {
            System.out.println("Пароль введён правильно!");
        } else {
            System.out.println("Пароль введён неправильно!");
        }
    }
}
