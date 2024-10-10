import java.util.Scanner;

public class Estatisticas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int new_input = input.nextInt();

        // Declarando as variaveis iniciais
        int soma = new_input;
        int maior = new_input;
        int menor = new_input;

        for (int i = 1; i < N; i++) {
            new_input = input.nextInt();

            soma += new_input;
            if (new_input > maior) {
                maior = new_input;
            }
            if (new_input < menor) {
                menor = new_input;
            }

        }
        input.close();

        int amplitude = maior - menor;
        double media = (double) soma / N;

        System.out.println(String.format("%.2f", media));
        System.out.println(amplitude);
    }
}