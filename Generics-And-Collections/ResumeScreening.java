import java.util.*;

abstract class JobRole {
    private String title;
    public JobRole(String title) { this.title = title; }
    public String getTitle() { return title; }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    public DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    public ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    private T role;
    public Resume(T role) { this.role = role; }
    public T getRole() { return role; }

    public static void screenResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resume for: " + role.getTitle());
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        List<JobRole> resumes = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
        Resume.screenResumes(resumes);
    }
}
