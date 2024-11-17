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

    public void removeFirst() {
        if (isEmpty())
            return;
        if (size == 1) {
            last = null;
        } else {
            last.setNext(last.getNext().getNext()); // Now last will be pointing to the second element
        }
        size--;
    }

    public void removeLast() {
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

    public String toString() {
        String str = "{";
        if (!isEmpty()) {
            Node<T> cur = last.getNext();
            for (int i = 0; i < size; i++) {
                str += cur.getValue();
                if (cur != last)
                    str += ",";
                cur = cur.getNext();
            }
        }
        str += "}";
        return str;
    }
}
