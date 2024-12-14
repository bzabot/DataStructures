public class LinkedListStack<T> implements MyStack<T> {
    DoublyLinkedList<T> list;

    LinkedListStack() {
        list = new DoublyLinkedList<>();

    }

    public void push(T v) {
        list.addFirst(v);

    };

    public T pop() {
        T v = list.getFirst();
        list.removeFirst();
        return v;

    };

    public T top() {
        return list.getFirst();
    };

    public int size() {
        return list.size();
    };

    public boolean isEmpty() {
        return (list.isEmpty());
    };

    public String toString() {
        return list.toString();
    }
}