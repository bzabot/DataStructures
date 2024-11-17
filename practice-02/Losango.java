/*
Mais sobre ciclos e procedimentos.
Crie um procedimento que, dado um N ímpar, escreva um losango de tamanho n no ecrã. Por exemplo, se n=5, o output deve ser: 
  #  
 ###
#####
 ###
  # 
 */

import java.util.Scanner;

public class Losango {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.close();

        // Losango superior
        for (int linha = 1; linha <= N / 2 + 1; linha++) {
            int n_caracteres = N / 2 + linha; // Número de caracteres da linha será a metade do
                                              // "comprimento" somado com a linha atual (começando de 1)
            int n_vazios = N - n_caracteres; //
            int n_cardinais = 2 * linha - 1; // O número de cardinais pode ser calculado tanto pelo número de vazios,
                                             // com (n_caracteres - n_vazios)

            imprime(n_vazios, ".");
            imprime(n_cardinais, "#");
            imprime(n_vazios, ".");
            System.out.println();
        }

        // Losango inferior
        for (int linha = 1; linha < N / 2 + 1; linha++) {
            int n_caracteres = N - linha; // N de caracteres nesse caso será o número total de caracteres - n_linha, 6,
                                          // 5, 4...
            int n_vazios = N - n_caracteres; // Também é igual a linha atual do loop
            int n_cardinais = n_caracteres - n_vazios; // Também é igual a N - 2*linha

            imprime(n_vazios, ".");
            imprime(n_cardinais, "#");
            imprime(n_vazios, ".");
            System.out.println();

        }
    }

    static void imprime(int n, String text) {
        for (int i = 0; i < n; i++) {
            System.out.print(text);
        }
    }
}
