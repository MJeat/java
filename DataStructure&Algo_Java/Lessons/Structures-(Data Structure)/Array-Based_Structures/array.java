

/*
Array - a collection of values of the same data type

This is a reference data type. It is located in the memory

Whatever is in the array is called Elements

Big Note:
== is used to compare the memory location of a string or string data type array. It's like saying are there two having the same memory location
.equals() is used to compare the value of any strings

 */

import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // For strings
        String[] notSortedfruits = {"mango","zebra","apply", "orange"};

        System.out.println(notSortedfruits); // This will print the memory address

        for(String i:notSortedfruits){
            System.out.println(i+ " ");
        }

        // Finding the lengths
        int fruitsArrayLength = notSortedfruits.length;
        System.out.println("The length of the array is: " +fruitsArrayLength);
        System.out.println("====================");

        // Learn more on how to sort items in an array
        //arraySortingMethod();

        // Practice
        //arrPractice(scanner);

        // Search an array
        searchAnArray(scanner);

        // practiceTwo searching
        //practiceTwo();

        // Reverse Array
        reverseArray();

        scanner.close();
    }
    static void arraySortingMethod(){
        String[] sortedFruits = {"mango","zebra","apply", "orange"};
        Arrays.sort(sortedFruits);
        for(String j: sortedFruits){
            System.out.println(j);
        }

        System.out.println("====================");
        // To fill or replace the entire array with a string
        Arrays.fill(sortedFruits,"pineapple");
        for(String z: sortedFruits){
            System.out.println(z);
        }
    }

    static void arrPractice(Scanner scanner){
        System.out.println("====================");

        int size;
        String[] foods;

        System.out.print("How many foods do you want: ");
        size = scanner.nextInt();
        scanner.nextLine();

        foods= new String[size];


        // Once it reaches 5, it will stop and break and print all in the array
        for(int i=0; i<size;i++){ // Do not put i<= size
            System.out.printf("Enter Food Name #%d: ",i+1);
            foods[i]= scanner.nextLine();

            if(i==size){
                break;
            }
        }
        System.out.println("You ordered: ");
        for(String j:foods){
            System.out.println(j);
        }

        /*

        Explanation for the i <= size:
        For example, Array has 4 spaces avaiable. That means it's from 0 to 3
        But, i <=size, if size is 4 that means the system is trying to find index number 4, while the array only has 3 at its longest

         */
    }

    static void searchAnArray(Scanner scanner) {

        // build a static array
        String[] foods = {"Hotdog", "pizza", "hamburger", "banana"};
        boolean found = false;

        //build input asking
        System.out.print("What do you wanna search for?: ");
        String input = scanner.nextLine();



            // If you want to find the index of the string, use
            /*
            for (int i = 0; i < foods.length; i++) {
                  if (foods[i].equalsIgnoreCase(input)) {
                       System.out.println("Element is found at index: " + i);
             */

            // If you want to find the string name, use
            /*
            for (String z:foods) {
                  if(foods[z].equalsIgnoreCase(input)){
                       System.out.println("Element is found at index: "+z);
             */


            /*
            == is used to compare the memory location of a string or string data type array. It's like saying are there two having the same memory location
            .equals() is used to compare the value of any strings
             */

            // build loop through array
            for (int z=0; z< foods.length;z++) {
                // need to compare the input to each element within the array
                if(foods[z].equalsIgnoreCase(input)){
                System.out.println("Element is found at index: "+z);
                found = true;
                break;
            }
        }
        // IF no found, return not found. Cannot use else inside the for loop, even if it's inside the if-loop.
        // That's why we create another loop outside the for loop
        if(!found){
            System.out.println("Not found");
        }
    }

    static void practiceTwo(){
        int[] nums = {1,2,3,45,65,43,78,6,8};
        int target =2;

        for(int i : nums) { // Use this if it's integer, but don't use this if for an Array String
            if (target == i) {
                System.out.println("found");
            }
        }
    }

    static void reverseArray(){
        int[] nums = {1,2,3};
        int[] reverse = new int[nums.length];

        // Read the documentation below
        for(int i=0,j=nums.length-1; i< nums.length ;i++,j--){
            reverse[j]  = nums[i];
        }
        for(int z : reverse) {
            System.out.println("Result Reverse: " + z);
        }


        /*
        The j and i are index number. If we use "nums.length", error space of array will appear bcuz the array only has maximum index of 2, but the length is 3. So, we need to minus one -> "nums.length-1"

        Why so many variables like i and j?
        i is for nums
        j is for reverse numbers - reverse version of nums

        How it works:
        i starts at 0 (beginning of nums).
        j starts at 2 (end of reverse).

        How it works:
        First iteration:
        i=0, j=2 → reverse[2] = nums[0] → reverse becomes [0, 0, 1].

        Second iteration:
        i=1, j=1 → reverse[1] = nums[1] → reverse becomes [0, 2, 1].

        Third iteration:
        i=2, j=0 → reverse[0] = nums[2] → reverse becomes [3, 2, 1].
         */
    }
}
