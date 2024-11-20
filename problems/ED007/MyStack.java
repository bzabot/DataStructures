public interface MyStack<T> {
    // Push an element to the stack
    public void push(T v);

    public T pop();

    public T top();

    public int size();

    public boolean isEmpty();

}