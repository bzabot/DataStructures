public class ED248 {
    public static void main(String[] args) {
        int n = 1000000;
        IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]

        /*
         * Escrever o resultado de cada uma das seguintes N operacoes
         * 12
         * s1 add 42
         * s1 add 42
         * s1 clear
         * s1 add 42
         * s1 add 21
         * s1 add 22
         * s1 add 23
         * s1 add 21
         * s1 add 42
         * s1 clear
         * s1 add 21
         * s1 add 42
         */

        System.out.println(s.add(42));
        System.out.println(s.add(42));
        s.clear();
        System.out.println(s.add(42));

    }
}

class BooleanArrayIntSet implements IntSet {
    private int size; // Numero de elementos do conjunto
    private boolean elem[]; // Array que contem os elementos em si

    BooleanArrayIntSet(int maxSize) {
        elem = new boolean[maxSize];
        size = 0;
    }

    public boolean contains(int x) {
        return elem[x - 1];
    }

    public boolean add(int x) {
        if (!contains(x)) {
            elem[x - 1] = true;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x) {
        if (contains(x)) {
            elem[x - 1] = false;
            return true;
        }
        if (x == size) {
            size--;
        }
        return false;
    }

    public void clear() {
        size = 0;

    }

    public int size() {
        return size;
    }

    public boolean equals(IntSet s) {
        for (int i = 0; i < size; i++) {
            if (this.elem[i] != s.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public IntSet intersection(IntSet s) {
        BooleanArrayIntSet intersection = new BooleanArrayIntSet(size);
        for (int i = 0; i < size; i++) {
            if (s.contains(i) && this.elem[i]) {
                intersection.add(i);
            }
        }
        return s;
    }

    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < size; i++) {
            res += elem[i];
        }
        res += "}";
        return res;
    }
}
