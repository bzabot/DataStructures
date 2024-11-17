public class CircularLinkedList<T> {
    private int size;
    private Node<T> last;

    CircularLinkedList() {
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(T v) {
        if (isEmpty()) {
            last = new Node<T>(v, null);
            last.setNext(last);
        } else {
            Node<T> newNode = new Node<T>(v, last.getNext()); // The newNode will be pointing to last.getNext (last
                                                              // first elem)
            last.setNext(newNode);
        }
        size++;
    }

    public void addLast(T v) {
        addFirst(v);
        last = last.getNext();
    }

    public void removeFirst(T v) {
        if (isEmpty())
            return;
        if (size == 1) {
            last = null;
        } else {
            last.setNext(last.getNext().getNext()); // Now last will be pointing to the second element
        }
        size--;
    }

    public void removeLast(T v) {
        if (isEmpty())
            return;
        if (size == 1) {
            last = null;
        } else {
            Node<T> cur = last.getNext();
            // While cur is not the last but one, get next
            while (cur.getNext() != last) {
                cur = cur.getNext();
            }
            // set to the first element
            last = cur;
            last.setNext(last.getNext().getNext());
            size--;
        }

    }

    public void rotate() {
        last = last.getNext();
    }
}
