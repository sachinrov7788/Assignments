import java.util.Scanner;

class QuickSortEg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Elements : ");

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Arrays : ");
        PrintArray(arr);

        QuickSort(arr, 0, n-1);

        System.out.println("Sorted Arrays : ");
        PrintArray(arr);

    }

    static void QuickSort(int[] arr, int low, int high){
        if(low < high){
            int sac = partition(arr, low, high);

            QuickSort(arr, low, sac-1);
            QuickSort(arr, sac+1, high);

        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void PrintArray(int[] arr){
        for(int value : arr){
            System.out.println(value+ " ");
        }
    }
}