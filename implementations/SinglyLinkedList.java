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

    // Return the element of a given pos
    public T get(int pos) {
        if (pos >= size || pos < 0)
            return null;

        Node<T> curr = first;
        for (int i = 0; i < pos; i++)
            curr = curr.getNext();
        return curr.getValue();
    }

    public T remove(int pos) {
        // If the list is empty
        if (isEmpty() || pos >= size || pos < 0)
            return null;

        Node<T> retur = first;
        Node<T> curr = first;
        // If we want to remove the first element
        if (pos == 0) {
            first = first.getNext();
        } else

        // If we want to remove the last element
        if (pos == size - 1) {

            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            retur = curr.getNext();
            curr.setNext(null);
        } else {
            // If we want to remove one element from the midle

            // Iterate till the element before pos
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.getNext();
            }
            // Now curr have the value of the node before pos
            retur = curr.getNext();
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return retur.getValue();

    }

    // Create a copy of the list
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        if (!isEmpty()) {
            Node<T> curr = first;
            newList.addLast(curr.getValue());
            while (curr.getNext() != null) {
                curr = curr.getNext();
                newList.addLast(curr.getValue());
            }
        }
        return newList;
    }

    // Duplicate each element of the list
    public void duplicate() {
        if (!isEmpty()) {
            Node<T> curr = first;

            // Caso não seja o último elemento
            while (curr.getNext() != null) {
                curr.setNext(new Node<>(curr.getValue(), curr.getNext()));
                curr = curr.getNext().getNext();
            }
            // No ultimo elemento
            curr.setNext(new Node<>(curr.getValue(), curr.getNext()));
            size *= 2;
        }
    }

    // Count the number of occurencies of value in the list
    public int count(T value) {
        int count = 0;
        Node<T> curr = first;
        for (int i = 0; i < size; i++) {
            if (curr.getValue().equals(value))
                count++;
            curr = curr.getNext();
        }
        return count;
    }

    public String toString() {

        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

}