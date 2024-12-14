/*
    1 2 
    3 
    1 2
    1 3
    1 5
 */

import java.util.Scanner;

class ED243 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pizza p = new Pizza(s);
        p.out_ing();
        p.pizzas();
        s.close();
    }
}

class Pizza {
    int[] out_ingredients;
    Scanner scn;
    int total;

    Pizza(Scanner s) {
        scn = s;
    }

    public void out_ing() {
        int n = scn.nextInt();
        out_ingredients = new int[n];
        for (int i = 0; i < n; i++) {
            out_ingredients[i] = scn.nextInt();
        }
    }

    public void pizzas() {
        int n1 = scn.nextInt(); // n de pizzas
        // Loop pizzas
        for (int i = 0; i < n1; i++) {
            int helper = 0;
            int n2 = scn.nextInt(); // n de ing da pizza

            // Looping da pizza i
            for (int j = 0; j < n2; j++) {
                int ing = scn.nextInt();
                // Se a pizza tem o ing
                if (checkIng(ing))
                    continue;
                else
                    helper++;
            }
            // Se nenhum ingrediente faz parte da pizza (helper foi somado em todos os
            // checks)
            if (helper == n2)
                total++; // É uma pizza possível
        }
        System.out.println(total);
    }

    public boolean checkIng(int ing) {
        for (int i = 0; i < out_ingredients.length; i++) {
            if (out_ingredients[i] == ing)
                return true; // Pizza com ingrediente
        }
        return false; // pizza sem ingrediente
    }
}