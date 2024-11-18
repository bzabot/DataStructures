public class ED197 {

    public static void main(String[] args) {
        MyQueue<Integer> a = new LinkedListQueue<>();
        MyQueue<Integer> b = new LinkedListQueue<>();

        a.enqueue(1);
        a.enqueue(2);
        b.enqueue(2);
        b.enqueue(3);

        System.out.println("C: " + merge(a, b));
    }

    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> c = new LinkedListQueue<>();

        while (a.size() != 0 || b.size() != 0) {
            if (a.first() == null)
                c.enqueue(b.dequeue());
            else if (b.first() == null)
                c.enqueue(a.dequeue());
            else if (a.first() <= b.first())
                c.enqueue(a.dequeue());
            else
                c.enqueue(b.dequeue());
        }
        return c;
    }
}