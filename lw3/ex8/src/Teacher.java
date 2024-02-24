import java.util.Random;

class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void gradeExam(Abiturient abiturient, Exam exam) {
        Random random = new Random();
        int score = random.nextInt(4)+2; // Рандомно от 2 до 5
        exam.setScore(score);
        System.out.println("Преподаватель " + name + " выставил оценку " + score + " абитуриенту " + abiturient.getName());
    }
}