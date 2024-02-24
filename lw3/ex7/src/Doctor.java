/**
 * Врач
 */
class Doctor {
    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    public void makePrescription(Patient patient, Prescription prescription) {
        prescription.execute(patient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}