package CustomDataSturctures;

import java.util.*;

public class CustomQueue implements AbstractQueue{

    private LinkedList<State> queue;
    public CustomQueue(){
        queue = new LinkedList();
    }

    @Override
    public void push(State element) {
        queue.add(element);
    }

    @Override
    public State pop() {
        return queue.removeFirst();
    }

    @Override
    public State peek() {
        return queue.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(String s) {
        return queue.contains(s);
    }

    @Override
    public int size() {
        return queue.size();
    }
}
