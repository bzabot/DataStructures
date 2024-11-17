import java.util.Arrays;
import java.util.Scanner;

public class Primos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        input.close();

        System.out.println(crivo_erastostenes(A, B));
    }

    public static int crivo_erastostenes(int A, int B) {

        // Criar uma lista booleana de tamanho B + 1 (para incluir B)
        boolean[] crivo = new boolean[B + 1];
        Arrays.fill(crivo, true);

        // Algoritmo do crivo
        for (int i = 2; i < B + 1; i++) {
            if (crivo[i] == true) {
                for (int j = 2 * i; j < B + 1; j += i) {
                    crivo[j] = false;
                }
            }
        }

        // Retornar o tamanho da lista
        int count = 0;
        for (int i = A; i < B + 1; i++) {
            if (crivo[i]) {
                count++;
            }
        }

        return count;
    }
}
