public class quickSortAlgo {
    public static void main(String[] args) {
        int[] arr = {4, 9, 7, 8, 1};
        
        System.out.println("Original: 4, 9, 7, 8, 1");
        quickSort(arr, 0, arr.length - 1);
        
        System.out.print("Sorted: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }
    
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];  // Last element as pivot
        int i = start - 1;
        
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place pivot in correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        
        return i;
    }
}