public class DelimiterCheckerTester {
    public static void main(String[] args) {
        System.out.println("Tester");

        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "((()))";
        String test4 = "[{()}]";
        String test5 = "{[}]";
        String test6 = "({[]}){}[]";
        String test7 = "(";
        String test8 = "No delimiters";

        System.out.println(test1 + " -> " + DelimiterChecker.check(test1));
        System.out.println(test2 + " -> " + DelimiterChecker.check(test2));
        System.out.println(test3 + " -> " + DelimiterChecker.check(test3));
        System.out.println(test4 + " -> " + DelimiterChecker.check(test4));
        System.out.println(test5 + " -> " + DelimiterChecker.check(test5));
        System.out.println(test6 + " -> " + DelimiterChecker.check(test6));
        System.out.println(test7 + " -> " + DelimiterChecker.check(test7));
        System.out.println(test8 + " -> " + DelimiterChecker.check(test8));

        System.out.println("All tests completed successfully!");
    }
}
