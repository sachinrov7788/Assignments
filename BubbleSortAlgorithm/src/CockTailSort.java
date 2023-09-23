import java.util.Scanner;


public class CockTailSort {

    static int sac =0;
    static int sac1 =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Element");

        int n = sc.nextInt();
        int arr[] = new int[n];
        int arr1[] = new int[n];

        System.out.println("Enter the element");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }


    arr1=arr;
        System.out.println("Original array");
        PrintArray(arr);

        cocktailSort(arr);
        BubbleSort(arr1);

        System.out.println("Cocktail");

        System.out.println("Sorted Array");
        PrintArray(arr);
        System.out.println("Total count : "+sac);

        System.out.println("BubbleSort");

        System.out.println("Sorted Array");
        PrintArray(arr1);
        System.out.println("Total count : "+sac1);

    }

    static void PrintArray (int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    static void BubbleSort(int arr[]){
        boolean swap;

        for(int i=0; i<arr.length; i++){
            sac1++;
            swap = false;

            for(int j=0; j< arr.length-i-1; j++){
                sac1++;
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

    static void cocktailSort(int[] arr) {
        boolean swap;
        int start = 0;
        int size = arr.length - 1;

        do {
            swap = false;

            for (int i = start; i < size; i++) {
                sac++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }

            swap = false;
            size--;

            for (int i = size - 1; i >= start; i--) {
                sac++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }

            start++;
            sac++;
        } while (swap);
        //System.out.println(sac);
    }
}
