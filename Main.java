






import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter delimiters: ");
        String expression = input.nextLine();

        boolean valid = true;
        String reason = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            System.out.println("\nRead: " + ch);

            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

                System.out.println("Operation: PUSH");
                System.out.println("Stack: " + stack);

            } else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {

                    valid = false;
                    reason = "Closing delimiter has no matching opening delimiter.";

                    System.out.println("Operation: INVALID");
                    System.out.println("Stack: " + stack);
                    break;
                }

                char top = stack.peek();

                System.out.println("Operation: PEEK -> " + top);

                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')) {

                    stack.pop();

                    System.out.println("Operation: POP");
                    System.out.println("Stack: " + stack);

                } else {

                    valid = false;
                    reason = "Mismatched delimiters.";

                    System.out.println("Operation: INVALID");
                    System.out.println("Stack: " + stack);
                    break;
                }
            }
        }

        if (valid && !stack.isEmpty()) {

            valid = false;
            reason = "Unmatched opening delimiter remains.";

            System.out.println("\nOperation: INVALID");
            System.out.println("Stack: " + stack);
        }

        if (valid) {

            System.out.println("\nResult: Valid");

        } else {

            System.out.println("\nResult: Invalid");
            System.out.println("Reason: " + reason);
        }

        input.close();
    }
}
