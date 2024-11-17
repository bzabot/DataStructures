public class DoublyLinkedList<T> {
    private DNode<T> first;
    private DNode<T> last;
    private int size;

    DoublyLinkedList() {
        first = new DNode<>(null, null, null);
        last = new DNode<>(null, first, null);
        first.setPrev(last);
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addBetween(T v, DNode<T> n1, DNode<T> n2) {
        DNode<T> newNode = new DNode<T>(v, n1, n2);
        n1.setNext(newNode);
        n2.setPrev(newNode);
        size++;
    }

    public void addFirst(T v) {
        addBetween(v, first, last);
    }

    public void addLast(T v) {
        addBetween(v, last.getPrev(), last);
    }

    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getNext().getValue();
    }

    public T getLast() {
        if (isEmpty())
            return null;
        return last.getPrev().getValue();
    }

    public void removeFirst() {
        if (isEmpty())
            return;
        remove(first.getNext());
    }

    public void removeLast() {
        if (isEmpty())
            return;
        remove(last.getPrev());
    }

    public void remove(DNode<T> n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
    }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";
        DNode<T> cur = first.getNext();
        for (int i = 0; i < size; i++) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != last)
                str += ",";
        }
        str += "}";
        return str;
    }

}
