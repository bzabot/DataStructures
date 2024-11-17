public class Pair {
    public int x;
    public int y;

    Pair(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public String toString() {
        String str = "(";
        str += x + "";
        str += ", ";
        str += y;
        str += ")";
        return str;
    }

}