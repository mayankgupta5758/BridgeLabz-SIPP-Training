// 7. Hospital Patient Management

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private String record;

    public InPatient(String id, String name, int age) {
        super(id, name, age);
    }

    public double calculateBill() {
        return 5000; // Fixed stay charge
    }

    public void addRecord(String record) {
        this.record = record;
    }

    public void viewRecords() {
        System.out.println("Record: " + record);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private String record;

    public OutPatient(String id, String name, int age) {
        super(id, name, age);
    }

    public double calculateBill() {
        return 1000; // OPD fee
    }

    public void addRecord(String record) {
        this.record = record;
    }

    public void viewRecords() {
        System.out.println("Record: " + record);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "Ravi", 45);
        Patient p2 = new OutPatient("P002", "Simran", 30);

        ((MedicalRecord)p1).addRecord("Surgery - 3 days stay");
        ((MedicalRecord)p2).addRecord("Flu consultation");

        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: Rs. " + p.calculateBill());
            ((MedicalRecord)p).viewRecords();
            System.out.println();
        }
    }
}
