import java.util.Scanner;

public class ED120 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Losango l = new Losango(n);
        l.superior();
        l.inferior();

        s.close();
    }
}

class Losango {
    private int tamanho;

    Losango(int n) {
        tamanho = n;
    }

    // Tamanho sempre vai ser ímpar
    public void superior() {
        // Até a metade
        for (int i = 0; i < tamanho / 2; i++) {
            int h = 2 * i + 1; // número de losangos da linha
            int p = tamanho - h; // número de pontos
            String line = getString(h, p);
            System.out.println(line);
        }
    }

    public void inferior() {
        // Numero de losangos = Tamanho da linha - 2*número da linha
        for (int i = 0; i <= tamanho / 2; i++) {
            int h = tamanho - 2 * i;
            int p = tamanho - h;
            String line = getString(h, p);
            System.out.println(line);
        }
    }

    public String getString(int h, int p) {
        String ans = "";
        // Coloca os pontos
        for (int i = 0; i < p / 2; i++) {
            ans += '.';
        }
        // Coloca os cardinais
        for (int i = 0; i < h; i++) {
            ans += '#';
        }
        // Coloca os pontos 2
        for (int i = 0; i < p / 2; i++) {
            ans += '.';
        }
        return ans;
    }
}