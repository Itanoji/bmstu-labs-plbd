/**
 * Назначение лекарства
 */
class MedicationPrescription extends Prescription {
    private String medication;

    public MedicationPrescription(Doctor who, String medication) {
        this.who = who;
        this.medication = medication;
    }

    @Override
    void execute(Patient patient) {
        System.out.println("Врач " + who + " вводит лекарство: " + medication + " пациенту " + patient);
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }
}