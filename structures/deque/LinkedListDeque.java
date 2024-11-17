public class LinkedListDeque<T> implements MyDeque<T> {

    DoublyLinkedList<T> list;

    LinkedListDeque() {
        list = new DoublyLinkedList<>();
    }

    public void addFirst(T x) {
        list.addFirst(x);
    };

    public void addLast(T x) {
        list.addLast(x);
    };

    public T removeFirst() {
        T ans = list.getFirst();
        list.removeFirst();
        return ans;

    };

    public T removeLast() {
        T ans = list.getLast();
        list.removeLast();
        return ans;
    };

    public T first() {
        return list.getFirst();
    };

    public T last() {
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