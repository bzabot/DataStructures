public class BooleanArrayIntSet implements IntSet {
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
