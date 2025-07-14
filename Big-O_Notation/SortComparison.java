import java.util.*;

public class SortComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
    }

    public static void mergeSort(int[] arr) {
        Arrays.sort(arr); 
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] original = new Random().ints(size, 0, size).toArray();

        int[] arr1 = original.clone();
        int[] arr2 = original.clone();
        int[] arr3 = original.clone();

        long start, end;

        start = System.nanoTime();
        bubbleSort(arr1);
        end = System.nanoTime();
        System.out.println("Bubble Sort: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        mergeSort(arr2);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort: " + (end - start) / 1_000_000.0 + " ms");
    }
}
