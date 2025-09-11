


// quick sort = moves smaller elements to left of a pivot.
//		recursively divide array in 2 partitions

//      run-time complexity = Best case O(n log(n))
//		Average case O(n log(n))
//		Worst case O(n^2) if already sorted

//      space complexity = O(log(n)) due to recursion


public class quickSort {
    public static void main(String[] args){

        int[] arr = {9,4,7,6,8,5,1,3,2}; // Unsorted array
        quickSort(arr, 0, arr.length-1); // 0 is to start from the beginning and arr.length-1 is the last element of the array

        for (int i : arr){
            System.out.print(i+" ");
        }
    }

    // Sorting area
    private static void quickSort(int[] arr, int start, int end){
        if (end <= start) return; // When we can't divide the array anymore, we return. OR this is a prevention if the array only has 1 or zero elements

        // Find the pivot
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1); // This is the LEFT half, counting from the pivot when it's in the middle. We don't count the pivot index, that's why we put pivot-1
        quickSort(arr, pivot+1, end); // This is the RIGHT half, counting from the pivot when it's in the middle. We don't count the pivot index, that's why we put pivot+1

    }

    private static int partition(int[] arr, int start, int end){
        
        int pivot =  arr[end]; // Let pivot stays as the last Index of an Array
        int i = start -1; // Tracks where the next smaller-than-pivot element should go
        
        // Start the interation
        for (int j = start; j<=end-1; j++){
            if(arr[j]< pivot){ // If one of the elements is lesser than the pivot, we want it on the left handside. 
                               // If the element is greater than the pivot, we want it on the right handside of the pivot. 
                i++;           // If the index found by j is smaller than the pivot index, move index found by i up by 1 index

                // Swapping
                int temp = arr[i]; // Index i assigns to temp variable  
                arr[i] = arr[j]; // Index j assigns to index i  
                arr[j] = temp; // temp variable assigns to index j   
            }
        }
        i++; // Move i to the pivot, leaving a few numbers behind it for later quickSort()

        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i; // Return the value of i to quickSort(). i is the location of our pivot
    }
}
