public class UnorderedArray{
    private Integer [] arr;
    private int count;

    public UnorderedArray(int size){
        arr = new Integer[size];
        count = 0;
    }
    //insert element at end - O(1)...
    public void insert(int x) {
        if (count == arr.length){
            resize(arr.length * 2); // If the array is full, double its size
        }
        arr[count++]=x;

    }
    //Delete element by replacing with the last element - O(n)
    public void delete(int x) {
        for (int i = 0; i < count; i++) {
            if (arr[i]==x){
                arr[i]=arr[count -1];
                arr[count-1]=null;
                count--;
                return;
            }
        }
    }
    // Linear search - O(n)
    public int find(int x) {
        for (int i =0; i <count; i++) {
            if (arr[i]==x) 
                return i;
        }
        return -1;
    }
    //Get element by index - O(1)
    public int get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return arr[index];
    }
    public int size() {
        return count;
    }
    //Resize array - O(n)
    public void resize(int newsize) {
        Integer[] newArr = new Integer[newsize];
        if (Math.min(count, newsize) >= 0) System.arraycopy(arr, 0, newArr, 0, Math.min(count, newsize));
        arr=newArr;
        if (count > newsize) count = newsize;

    }

}