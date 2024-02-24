import java.util.ArrayList;
import java.util.List;

public class Abiturient {
    private String name;
    private Faculty registeredFaculty;
    private List<Exam> exams;
    private double averageScore;
    private boolean isAdmited;

    public Abiturient(String name) {
        this.name = name;
        this.exams = new ArrayList<>();
    }

    public void registerForFaculty(Faculty faculty) {
        this.registeredFaculty = faculty;
    }

    public void takeExam(Exam exam, Teacher teacher) {
        teacher.gradeExam(this, exam);
    }

    public void calculateAverageScore() {
        if (!exams.isEmpty()) {
            double sum = exams.stream().mapToDouble(Exam::getScore).sum();
            averageScore = sum / exams.size();
        } else {
            averageScore = 0.0;
        }
    }

    public void displayAdmissionStatus() {
        String admissionStatus = isAdmited() ? "поступил(а)" : "не поступил(а)";
        System.out.println(name + " " + admissionStatus + " на факультет " + registeredFaculty.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getRegisteredFaculty() {
        return registeredFaculty;
    }

    public void setRegisteredFaculty(Faculty registeredFaculty) {
        this.registeredFaculty = registeredFaculty;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public boolean isAdmited() {
        return isAdmited;
    }

    public void setAdmited(boolean admited) {
        isAdmited = admited;
    }
}
