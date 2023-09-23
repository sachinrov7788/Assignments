import java.util.Scanner;

class BubbleSort {

    public static void main(String[] args)

    static void Bubblesort(int arr[]){
        boolean swap;

        for(int i=0; i<arr.length; i++){
            swap = false;

            for(int j=0; j< arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
            }
        }

    static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

