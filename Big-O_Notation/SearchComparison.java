import java.util.*;

public class SearchComparison {
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) if (num == target) return true;
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        Arrays.sort(arr); 
        return Arrays.binarySearch(arr, target) >= 0;
    }

    public static void main(String[] args) {
        int size = 1000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;

        int target = size - 1;

        long start = System.nanoTime();
        linearSearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        binarySearch(arr, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
