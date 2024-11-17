public interface MyDeque<T> {
    public void addFirst(T x);

    public void addLast(T x);

    public T removeFirst();

    public T removeLast();

    public T first();

    public T last();

    public int size();

    public boolean isEmpty();
}