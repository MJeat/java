public class DelimiterChecker {

    public static boolean check(String input) {
        Stack<Character> stack = new Stack<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Push opening delimiters
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Check for closing delimiters
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stackIsEmpty(stack)) return false;

                char top = stack.pop();

                // Check matching pairs
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // All delimiters must be matched
        return stackIsEmpty(stack);
    }

    private static boolean stackIsEmpty(Stack<Character> stack) {
        try {
            stack.peek(); // Throws exception if empty
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
