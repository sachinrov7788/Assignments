import java.util.Scanner;

class MergeSortEg{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Elements : ");

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Original Array : ");
        printArray(arr);

//        mergeSort(arr, 0, n-1);
//
//        System.out.println("Sorted Array : ");
//        printArray(arr);
    }


    public static void printArray(int[] arr){
        for(int val : arr){
            System.out.println(val+" ");
        }
        System.out.println();
    }
}