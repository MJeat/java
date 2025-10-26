
import java.util.LinkedList;


  // *******************************************************
  // LinkedList =  Nodes are in 2 parts (data + address)
  //                        Nodes are in non-consecutive memory locations
  //                        Elements are linked using pointers
  // LinkedList is really good at insertion and deletion, but not so much on accessing and searching
            
  //    advantages?
  //    1. Dynamic Data Structure (allocates needed memory while running)
  //    2. Insertion and Deletion of Nodes is easy. O(1) 
  //    3. No/Low memory waste
  
  //    disadvantages?
  //    1. Greater memory usage (additional pointer)
  //    2. No random access of elements (no index [i])
  //    3. Accessing/searching elements is more time consuming. O(n)
  
  //    uses?
  //    1. implement Stacks/Queues
  //    2. GPS navigation
  //    3. music playlist
  // *******************************************************

public class linkedList{
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<String>();

        // Treat linkedlist as a stack
        // linkedList.push("A");
        // linkedList.push("B");
        // linkedList.push("C");
        // linkedList.pop(); // Removes the previous inserted/pushed element
        // System.out.println(linkedList);        

        // Treat linkedlist as a queue
        linkedList.offer("Z");
        linkedList.offer("Y");
        linkedList.offer("X");
        // linkedList.poll(); // Removes the previous inserted/pushed element

        linkedList.add(2,"P");
        linkedList.remove("P");
        System.out.println(linkedList.indexOf("Z")); // Searching based on the index

        System.out.println(linkedList.peekFirst()); 
        System.out.println(linkedList.peekLast()); 

        System.out.println("=== Adding elements to the first and last ===\n"+linkedList);
        linkedList.addFirst("0"); // Adding elements to the head of the queue
        linkedList.addLast("1"); // Adding elements to the tail of the queue
        
        System.out.println("=== Removing elements to the first and last ===\n"+linkedList+"\n");
        linkedList.removeFirst(); // Removing elements to the head of the queue
        linkedList.removeLast(); // Removing elements to the tail of the queue

    
        //System.out.println(linkedList);

    }
}