import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Faculty {
    private String name;
    private int budgets;
    private List<Abiturient> abiturientList;

    public Faculty(String name, int budgets) {
        this.name = name;
        this.budgets = budgets;
        this.abiturientList = new ArrayList<>();
    }

    public void calculateWhoAdmitted() {
        abiturientList.forEach(Abiturient::calculateAverageScore);
        abiturientList.stream()
                .sorted(Comparator.comparingDouble(Abiturient::getAverageScore).reversed())
                .limit(budgets)
                .forEach(a -> a.setAdmited(true));
    }

    public void printResults() {
        abiturientList.forEach(Abiturient::displayAdmissionStatus);
    }

    public void addAbiturient(Abiturient abiturient) {
        abiturientList.add(abiturient);
    }

    public String getName() {
        return name;
    }

    public int getBudgets() {
        return this.budgets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudgets(int budgets) {
        this.budgets = budgets;
    }

    public List<Abiturient> getAbiturientList() {
        return abiturientList;
    }

    public void setAbiturientList(List<Abiturient> abiturientList) {
        this.abiturientList = abiturientList;
    }
}