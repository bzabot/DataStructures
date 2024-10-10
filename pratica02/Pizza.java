/*
Input
1 2 (Número de ingredientes - Identificadores dos ingredientes que não gosta)
3 (Número de pizzas)
1 1 (Número de ingredimentes - Identificadores)
1 2 (Número de ingredimentes - Identificadores)
1 3 (Número de ingredimentes - Identificadores)





 */

import java.util.Scanner;

public class Pizza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Cria um array com todos os ingredientes que o Mario não gosta
        int[] nao_ing = new int[input.nextInt()];
        for (int i = 0; i < nao_ing.length; i++) {
            nao_ing[i] = input.nextInt();
        }

        // Numero de pizzas
        int n_pizzas = input.nextInt();
        int n_pizzas_possiveis = 0;

        for (int i = 0; i < n_pizzas; i++) { // Loop pelo número de pizzas

            int n_ingredientes = input.nextInt(); // Número de ingrediente da respetiva pizza
            int count = 0; // Contagem pra verificar se o ingrediente está ou não na pizza
            for (int j = 0; j < n_ingredientes; j++) { // Loop pelo número de ingredientes
                int ingrediente = input.nextInt(); // Código do atual ingrediente

                for (int k = 0; k < nao_ing.length; k++) { // Loop pelo array dos nao-ingredientes
                                                           // Se um ingrediente existe na pizza, aumenta a variável
                                                           // count
                    if (ingrediente == nao_ing[k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 0) {
                n_pizzas_possiveis++; // Se count == 0 (nenhum dos ingredientes está na respectiva pizza, logo é uma
                                      // pizza possível)
            }

        }

        System.out.println(n_pizzas_possiveis);

        input.close();
    }
}
