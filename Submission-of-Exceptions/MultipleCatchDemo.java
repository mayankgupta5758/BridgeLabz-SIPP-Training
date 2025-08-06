import java.util.*;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        Scanner sc = new Scanner(System.in);

        try {
            arr[0] = 10;
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            sc.close();
        }
    }
}
