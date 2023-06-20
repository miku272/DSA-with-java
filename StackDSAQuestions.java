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

    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> stockStack = new Stack<>();

        span[0] = 1;
        stockStack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];

            while (!stockStack.isEmpty() && currentPrice > stocks[stockStack.peek()]) {
                stockStack.pop();
            }

            if (stockStack.isEmpty()) {
                span[i] = i + 1;
            } else {
                int previousHigh = stockStack.peek();
                span[i] = i - previousHigh;
            }

            stockStack.push(i);
        }
    }

    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();

        // stack.push(1);
        // stack.push(2);
        // stack.push(3);

        // System.out.println(stack.toString());

        // // pushAtBottom(4, stack);
        // reverseStack(stack);

        // System.out.println(stack.toString());

        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stocks.length];

        stockSpan(stocks, span);

        for (int i : span) {
            System.out.print(i + " ");
        }
    }
}
