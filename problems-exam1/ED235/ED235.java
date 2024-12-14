import java.util.Scanner;

class ED235 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Triangle T = new Triangle(s);
        T.writeT();
        s.close();

    }
}

class Triangle {
    private Scanner scn;
    private int n;
    private String ans = "";

    Triangle(Scanner s) {
        scn = s;
        n = scn.nextInt();
    }

    public void writeT() {
        for (int i = 0; i < n; i++) {
            createT(scn.nextInt());
        }
        System.out.println(ans);
    }

    public void createT(int size) {
        // Para cada linha
        for (int i = 0; i < size; i++) {
            getLine(i, size);
        }

    }

    public void getLine(int line, int size) {
        // O número de # é igual o tamanho - numero da linha
        for (int i = 0; i < size; i++) {
            if (i < size - line)
                ans += "#";
            else
                ans += ".";
        }
        ans += "\n";

    }

}