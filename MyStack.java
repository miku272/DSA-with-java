import java.util.ArrayList;

class ArrayListStack {
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty...");
            return Integer.MIN_VALUE;
        }

        int topData = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        return topData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty...");
            return Integer.MIN_VALUE;
        }

        return list.get(list.size() - 1);
    }
}

public class MyStack {
    public static void main(String[] args) {
        ArrayListStack stack = new ArrayListStack();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
