public class TestUnorderedArray {
    public static void main(String[] arg){

        // Declaring the UnorderedArray.java as a variable in TestUnorderedArray.java. The variable is called ua
        UnorderedArray ua = new UnorderedArray(10);

        // Insertion
        ua.insert(20);
        ua.insert(80);
        ua.insert(60);
        System.out.println("Inserted Elements");

        // Printing Elements from the Array
        System.out.println("Printing all the elements from the array: ");
        for (int i=0; i< ua.size();i++){
            System.out.print(ua.get(i)+ " ");
        }

        // Showing size
        System.out.println("\nSize: "+ua.size());

        // Delete an element from the array
        ua.delete(20);
        System.out.printf("Deleting an element from an array");
        // Printing Elements from the Array After Deletion
        System.out.println("Printing all the elements from the array: ");
        for (int i=0; i< ua.size();i++){
            System.out.print(ua.get(i)+ " ");
        }
    }
}
