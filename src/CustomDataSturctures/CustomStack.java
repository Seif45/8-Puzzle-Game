package CustomDataSturctures;

import java.util.Stack;

public class CustomStack implements AbstractQueue{
    private Stack<State> stack;

    public CustomStack(){
        stack = new Stack();
    }

    @Override
    public void push(State element) {
        stack.push(element);
    }

    @Override
    public State pop() {
        return stack.pop();
    }

    @Override
    public State peek() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean contains(String s) {
        return stack.contains(s);
    }

    @Override
    public int size() {
        return stack.size();
    }
}
