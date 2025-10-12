

/*
Stack is LIFO - Last In First Out
Stack has 5 unqiue methods: 
pop - remove the top object of the stack
push, 
peek - to see what's at the top
search, 
empty


 */

import java.util.Stack;
public class stack{
    public static void main(String[] args){

        // Declare different Stack type
        Stack<String> stack = new Stack<String>();
        Stack<Integer> number = new Stack<Integer>();

        // Checks if empty
        //System.out.println(stack.empty());

        // Adding elements into stack
        stack.push("Minecraft");
        stack.push("Roblox");
        stack.push("Terria");
        number.push(1999);

        // Printing or displaying elements of stacks
        System.out.println(stack);
        System.out.println(number);

        // Removing elements of stacks
        stack.pop(); // Will always remove the top element 
        System.out.println(stack);

        // If you just want to see what's at the top
        System.out.println(stack.peek());

        // To search a known object
        System.out.println(stack.search("Minecraft"));
        /*
         * The top position of the stack is 1
         * Follow by 2 and so on
         * 
         * If none is found in the stack, returns -1
         */

    }
}