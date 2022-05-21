package CustomDataSturctures;

public interface AbstractQueue {

    public void push(State element);

    public State pop();

    public State peek();

    public boolean isEmpty();

    public boolean contains(String s);

    public int size();
}
