
public class UnorderedArray {
    private Integer[] arr;
    private int countElements;
    public UnorderedArray(int size) {
        arr = new Integer[size];
        countElements = 0;
    }
    public void insert (int x){
        if(countElements == arr.length) resize(arr.length*2);
        arr[countElements++]= x; 

    }

    public void delete (int x){


    }

    public int find(int x){
        
        return -1;

    }

    public int get(int index){
        if (index < 0 || index >= countElements) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + countElements);
    }
    return arr[index];

    }

    public int size(){
        return countElements;
    }

    // Manually resize the array from the testing file
    public void resize(int newSize){

    }

}
