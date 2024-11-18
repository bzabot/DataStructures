public interface MyQueue<T> {
    public void enqueue(T x);

    public T dequeue();

    public T first();

    public int size();

    public boolean isEmpty();
}