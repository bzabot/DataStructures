/*
 Implementation of a NODE
 (NODE, NEXT_NODE)
 */
public class DNode<T> {
    private T value;
    private DNode<T> next;
    private DNode<T> prev;

    DNode(T v, DNode<T> n1, DNode<T> n2) {
        value = v;
        next = n1;
        prev = n2;

    }

    public T getValue() {
        return value;
    }

    public DNode<T> getNext() {
        return next;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setValue(T v) {
        value = v;
    }

    public void setNext(DNode<T> n) {
        next = n;
    }

    public void setPrev(DNode<T> n) {
        prev = n;
    }
}