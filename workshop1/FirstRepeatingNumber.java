
public class FirstRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 1, 2 };
        int[] freq = new int[arr.length];

        for (int i : arr) {
            if (freq[i] == 0) {
                freq[i]++;
            } else {
                System.out.println("First repeting element in an array is: " + i);
                break;
            }
        }
    }
}
