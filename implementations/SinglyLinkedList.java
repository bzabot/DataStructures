/*  
Implement a LinkedList (Singly to not conflict with Java's)




*/

public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(T value) {
        first = new Node<T>(value, first);
        size++;
    }

    public void addLast(T value) {
        Node<T> last = new Node<T>(value, null);
        // Exceptionally, if the list is empty, the first element will be the last
        if (isEmpty()) {
            first = last;
        } else {
            Node<T> curr = first;
            // While curr is not the last element
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }

            // Now curr is the last element
            curr.setNext(new Node<T>(value, null));
        }
        size++;
    }

    public T getFirst() {
        // Deal with NullPointerException
        if (isEmpty())
            return null;
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> curr = first;
        // One way to implement
        /*
         * for (int i = 0; i < size - 1; i++) {
         * curr = curr.getNext();
         * }
         */

        // Another way to implement
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        return curr.getValue();
    }

    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            return;

        Node<T> curr = first;
        // Another implementation could be if first.getNext() == null
        if (size == 1) {
            first = null;

        } else {
            // When two nodes next to curr is null we stop
            // Node1 --> curr --> Node3 --> null (We stop here)
            // Now curr can point to null
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(null);
        }
        size--;
    }

    public String toString() {

        if (isEmpty())
            return "{}";

        String ans = "{";
        Node<T> curr = first;
        while (curr.getNext() != null) {
            ans += curr.getValue() + ", ";
            curr = curr.getNext();
        }

        ans += curr.getValue() + "}";
        return ans;
    }
    /*
     * ▶ String toString() - representação em String (para impressão
     */

}