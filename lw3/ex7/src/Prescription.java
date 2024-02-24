/**
 * Назначение
 */
abstract class Prescription {
    protected Doctor who;
    abstract void execute(Patient patient);

    public Doctor getWho() {
        return who;
    }

    public void setWho(Doctor who) {
        this.who = who;
    }
}