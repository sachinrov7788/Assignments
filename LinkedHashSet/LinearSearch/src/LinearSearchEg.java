public class LinearSearchEg {
    public static void main(String[] args) {
        int[] arr = {12, 45, 32, 43 , -2};
        int target = 32;
        
        int sum = Linearsearch(arr, target);
        System.out.print(sum);
        
    }

    static int Linearsearch(int arr[], int target){
        if(arr.length == 0){
            return -1;
        }

        for(int i=0; i<arr.length; i++){
            int index;
            int element = arr[i];

            if(element == target){
                return i;
            }
        }

        return -1;
    }
}