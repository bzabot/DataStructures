public class ED196 {

    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        while (q.first() != null) {

            String fila = q.dequeue();
            String nome = q.dequeue();

            if (fila.equals("A"))
                a.enqueue(nome);
            if (fila.equals("B"))
                b.enqueue(nome);
            if (fila.equals("X")) {
                if (a.size() > b.size())
                    b.enqueue(nome);
                if (b.size() > a.size())
                    a.enqueue(nome);
            }
        }
    }
}