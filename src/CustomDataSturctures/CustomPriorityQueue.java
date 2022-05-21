package CustomDataSturctures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomPriorityQueue implements AbstractQueue{

    private PriorityQueue<State> priorityQueue;

    public CustomPriorityQueue(Comparator comparator){
        priorityQueue = new PriorityQueue(comparator);
    }

    @Override
    public void push(State element) {
        priorityQueue.add(element);
    }

    @Override
    public State pop() {
        return priorityQueue.poll();
    }

    @Override
    public State peek() {
        return priorityQueue.peek();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public boolean contains(String s) {
        return priorityQueue.contains(s);
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}
