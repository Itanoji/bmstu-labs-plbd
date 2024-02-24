/**
 * Назначение процедуры
 */
class ProcedurePrescription extends Prescription {
    private String procedure;

    public ProcedurePrescription(Doctor who, String procedure) {
        this.who = who;
        this.procedure = procedure;
    }

    @Override
    void execute(Patient patient) {
        System.out.println("Врач " + who + " проводит процедуру: " + procedure + " пациенту " + patient);
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}