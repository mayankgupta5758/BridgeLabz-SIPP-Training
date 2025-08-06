import java.io.*;

public class StudentDataBinary {
    public static void main(String[] args) {
        String filename = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101);
            dos.writeUTF("Mayank");
            dos.writeDouble(8.9);

            dos.writeInt(102);
            dos.writeUTF("Sakshi");
            dos.writeDouble(9.2);

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
