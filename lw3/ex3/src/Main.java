import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        long id = 0;
        patients.add(new Patient(id++,
                "Владислав",
                "Зыкин",
                "Николаевич",
                "Москва",
                "12345",
                1,
                "Усталость"));
        patients.add(new Patient(id++,
                "cxvxvc",
                "fff",
                "czxcd",
                "Москва",
                "12345",
                2,
                "Смерть"));
        patients.add(new Patient(id++,
                "ывпывп",
                "смичс",
                "ывавыа",
                "Москва",
                "12345",
                3,
                "Усталость"));
        patients.add(new Patient(id++,
                "счмисм",
                "апывп",
                "вапывап",
                "Москва",
                "12345",
                4,
                "Смерть"));
        patients.add(new Patient(id++,
                "ЫВпвыапр",
                "пвыапвыа",
                "вапваыпваып",
                "Москва",
                "12345",
                5,
                "Усталость"));

        Scanner in = new Scanner(System.in);
        System.out.println("Введите диагноз:");
        String diagnose = in.nextLine();
        System.out.println("Пациенты, обладающие диагнозом \"" + diagnose + "\":");
        getPatientsWithDiagnose(patients, diagnose).stream().map(Patient::toString).forEach(System.out::println);
        System.out.println("Задайте интервал номера мед. карты:");
        int a = in.nextInt();
        int b = in.nextInt();
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
