public class Main {
    public static void main(String[] args) {

        Faculty faculty = new Faculty("Прикладная информатика", 2);

        Abiturient abiturient1 = new Abiturient("ВВ АА ЫЫ");
        Abiturient abiturient2 = new Abiturient("sd fsadh ffds");
        Abiturient abiturient3 = new Abiturient("sdf sdf sdf");

        //Регистрация на факультеты
        faculty.addAbiturient(abiturient1);
        faculty.addAbiturient(abiturient2);
        faculty.addAbiturient(abiturient3);
        abiturient1.registerForFaculty(faculty);
        abiturient2.registerForFaculty(faculty);
        abiturient3.registerForFaculty(faculty);

        Exam mathExam = new Exam("Математика");
        Exam infoExam = new Exam("Информатика");

        // Преподователь
        Teacher teacherMath = new Teacher("ВВ фф СС");
        Teacher teacherInfo = new Teacher("FFd dsf dfsdf");

        // Сдача экзаменов
        abiturient1.takeExam(mathExam, teacherMath);
        abiturient2.takeExam(mathExam, teacherMath);
        abiturient3.takeExam(mathExam, teacherMath);

        abiturient1.takeExam(infoExam, teacherInfo);
        abiturient2.takeExam(infoExam, teacherInfo);
        abiturient3.takeExam(infoExam, teacherInfo);

        faculty.calculateWhoAdmitted();
        faculty.printResults();


    }
}
