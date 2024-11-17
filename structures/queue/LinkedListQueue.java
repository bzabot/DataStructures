public class LinkedListQueue<T> implements MyQueue<T> {
    DoublyLinkedList<T> list;

    LinkedListQueue() {
        list = new DoublyLinkedList<>();
    }

    public void enqueue(T x) {
        list.addLast(x);
    };

    public T dequeue() {
        T ans = list.getLast();
        list.removeLast();
        return ans;
    };

    public T first() {
        return list.getLast();
    };

    public int size() {
        return list.size();
    };

    public boolean isEmpty() {
        return list.isEmpty();
    };

    public String toString() {
        return list.toString();
    }

}