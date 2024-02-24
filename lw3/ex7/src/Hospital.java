import java.util.ArrayList;
import java.util.List;

/**
 * Больница
 */
class Hospital {
    private List<Patient> patients;

    public Hospital() {
        this.patients = new ArrayList<>();
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println(patient + " поступил в больницу..");
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}