import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество пациентов");
        int n;
        while(true) {
            try {
                n = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Невернный ввод. Повторите ещё раз.");
                in.next();
            }
        }
        in.nextLine();
        for(int i = 0; i < n; i++) {
            System.out.println("Введите данные пациента (ФИО, адрес, телефон, карта, диагноз)");
            try {
                System.out.println("Имя");
                String name = in.nextLine();
                System.out.println("Фамилия");
                String second = in.nextLine();
                System.out.println("Отчество");
                String patronymic = in.nextLine();
                System.out.println("Адрес");
                String address = in.nextLine();
                System.out.println("Телефон");
                String phone = in.nextLine();
                System.out.println("Номер карты");
                int card = in.nextInt();
                in.nextLine();
                System.out.println("Диагноз");
                String diag = in.nextLine();
                Patient patient = new Patient(i, name, second, patronymic, address, phone, card, diag);
                System.out.println(patient);
                patients.add(patient);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Введите пациента заново!");
                i--;
            }
        }
        System.out.println("Введите диагноз:");
        String diagnose = in.nextLine();
        System.out.println("Пациенты, обладающие диагнозом \"" + diagnose + "\":");
        getPatientsWithDiagnose(patients, diagnose).stream().map(Patient::toString).forEach(System.out::println);
        System.out.println("Задайте интервал номера мед. карты:");
        int a, b;
        while(true) {
            try {
                a = in.nextInt();
                b = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Повоторите.");
                in.next();
            }
        }
        System.out.println("Пациенты с номером карты в интервале [" + a + ";" + b + "]:");
        getPatientsInInterval(patients,a,b).stream().map(Patient::toString).forEach(System.out::println);
    }

    public static List<Patient> getPatientsWithDiagnose(List<Patient> patients, String diagnose) {
        return patients.stream().filter(p -> p.getDiagnose().equals(diagnose)).collect(Collectors.toList());
    }

    public static List<Patient> getPatientsInInterval(List<Patient> patients, int a, int b) {
        return patients.stream().filter(p->p.getCardNumber() >= a && p.getCardNumber() <= b).collect(Collectors.toList());
    }

}
