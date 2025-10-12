public class StringReverser {
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (true) {
            try {
                 reversed.append(stack.pop());
            } catch (Exception e) {
                break;
            }
        }
        return reversed.toString();
    }

}
