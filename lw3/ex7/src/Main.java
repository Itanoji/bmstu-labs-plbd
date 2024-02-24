public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor("Dr. Smith");
        Patient patient = new Patient("John Doe");
        patient.setAttendingDoctor(doctor);
        hospital.admitPatient(patient);
        Prescription procedurePrescription = new ProcedurePrescription(doctor,"X-ray");
        patient.receivePrescription(procedurePrescription);

        Prescription medicationPrescription = new MedicationPrescription(doctor,"Painkiller");
        patient.receivePrescription(medicationPrescription);
        patient.discharge();
    }
}
