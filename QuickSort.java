import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args){

        System.out.println("Enter the Array Size: ");

        Scanner myInput = new Scanner(System.in);

        int arraySize = myInput.nextInt();

        int[] array = new int [arraySize]; 

        System.out.println("Enter the Array Elements: ");
        for(int x = 0; x < arraySize; x++){
            array[x] = myInput.nextInt();


        }
        System.out.println("Sorted Array: ");
        
        quickSort(array, 0, array.length -1);

        for(int i: array){
            System.out.print(i + " ");
        }
    }
    
    public static void quickSort(int[] array, int start, int end){

        if(end <=start) return; //Base Function
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);

    }

    public static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j<= end -1; j++){
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i] = array [j];
                array[j] = temp;

            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
