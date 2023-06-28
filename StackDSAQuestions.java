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

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.print("\n");
    }

    public static void nextGreaterElement(int[] arr) {
        int[] nextGreater = new int[arr.length];
        Stack<Integer> s = new Stack<Integer>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        printArray(arr);
        printArray(nextGreater);
    }

    public static boolean isValidParentheses(String parentheses) {
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }

                if ((s.peek() == '(' && ch == ')') || (s.peek() == '[' && ch == ']')
                        || (s.peek() == '{' && ch == '}')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (!s.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean isDuplicateParentheses(String expression) {
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ')') {
                int count = 0;

                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }

        return false;
    }

    public static int maxAreaInHistogram(int[] heights) {
        int[] nextSmallerLeft = new int[heights.length];
        int[] nextSmallerRight = new int[heights.length];
        int maxArea = 0;

        // Calculating next smaller right
        Stack<Integer> s = new Stack<Integer>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextSmallerRight[i] = heights.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }

            s.push(i);
        }

        // Calculating next smaller left
        s = new Stack<Integer>();

        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }

            s.push(i);
        }

        // Calculate current area and check if it's the max area
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;

            int currArea = height * width;

            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
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

        // int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        // int[] span = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i : span) {
        // System.out.print(i + " ");
        // }

        // int[] arr = { 6, 8, 0, 1, 3 };
        // nextGreaterElement(arr);

        // String parentheses = "({}{{}()})";
        // System.out.println(isValidParentheses(parentheses));

        // String expression = "((a + b))";
        // System.out.println(isDuplicateParentheses(expression));

        // int[] heights = { 2, 1, 5, 6, 2, 3 };
        // System.out.println(maxAreaInHistogram(heights));
    }
}
