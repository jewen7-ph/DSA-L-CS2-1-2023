/*Eusebio, Alain Eleazar V.     
  BSCS 2-1
  OE6-Lab*/


import java.util.*; //For Scanner and Random Number Generator

public class HybridQuickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.print("Before sorting: ");
        printArray(arr);

        hybridQuicksort(arr, 0, n-1);

        System.out.print("After sorting: ");
        printArray(arr);
    }

    public static void hybridQuicksort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low < 10) {
                insertionSort(arr, low, high);
            } else {
                int pi = partition(arr, low, high);

                hybridQuicksort(arr, low, pi - 1);
                hybridQuicksort(arr, pi + 1, high);
            }
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}