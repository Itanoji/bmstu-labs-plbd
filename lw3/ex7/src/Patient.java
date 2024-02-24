/**
 * Пациент
 */
class Patient {
    private String name;
    private Doctor attendingDoctor;
    private boolean discharged;

    public Patient(String name) {
        this.name = name;
        this.discharged = false;
    }

    public void setAttendingDoctor(Doctor doctor) {
        this.attendingDoctor = doctor;
    }

    public void receivePrescription(Prescription prescription) {
        attendingDoctor.makePrescription(this, prescription);
    }

    public void discharge() {
        discharged = true;
        System.out.println(name + " выписан из больницы.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getAttendingDoctor() {
        return attendingDoctor;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    @Override
    public String toString() {
        return name;
    }
}