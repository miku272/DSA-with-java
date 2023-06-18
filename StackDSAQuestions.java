import java.util.Stack;

public class StackDSAQuestions {
    public static void pushAtBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);

            return;
        }

        int extractedData = stack.pop();
        pushAtBottom(data, stack);
        stack.push(extractedData);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int extractedData = stack.pop();
        reverseStack(stack);
        pushAtBottom(extractedData, stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);


        System.out.println(stack.toString());

        pushAtBottom(4, stack);

        System.out.println(stack.toString());
    }
}
