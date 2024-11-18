import java.util.Scanner;

public class ED231 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Estatisticas est = new Estatisticas(s);
        est.input();
        est.analise();
        s.close();
    }
}

class Estatisticas {
    Scanner scn;

    int dias;
    int[] casos;
    int flag;

    Estatisticas(Scanner s) {
        scn = s;
    }

    public void analise() {
        switch (flag) {
            case 1:
                flag1();
                break;
            case 2:
                flag2();
                break;
            case 3:
                flag3();
                break;
            default:
                break;
        }
    }

    public void input() {
        dias = scn.nextInt();
        casos = new int[dias];
        for (int i = 0; i < dias; i++) {
            casos[i] = scn.nextInt();
        }
        flag = scn.nextInt();
    }

    public void flag1() {
        int b = casos[1] - casos[0];
        int l = casos[1] - casos[0];
        // Maior e menor aumento entre dois dias
        for (int i = 2; i < dias; i++) {
            if (casos[i] - casos[i - 1] > b)
                b = casos[i] - casos[i - 1];
            if (casos[i] - casos[i - 1] < l)
                l = casos[i] - casos[i - 1];
        }
        System.out.println(l + " " + b);
    }

    public void flag2() {
        float[] percents = new float[dias - 1];

        // Criar um vetor com os aumentos percentuais
        for (int i = 1; i < dias; i++) {
            percents[i - 1] = (casos[i] - casos[i - 1]) * (float) 100.0 / casos[i - 1];
        }

        // Períodos de dias consecutivos com aumento percentual <= 5:
        int bp = 0;
        int consec = 0;
        int i = 0;
        while (i < percents.length) {
            if (percents[i] <= 5) {
                // Checar tamanho do período
                int size = 1;
                while (percents[i] <= 5 && i < percents.length - 1) {
                    size++;
                    i++;
                }
                if (size > consec) // Se o tamanho do período atual, for maior que o maior período encontrado até
                                   // agora:
                    consec = size;

                // Somar += 1 período
                bp++;
            }
            i++;

        }

        System.out.println(bp + " " + consec); // Numero de períodos + Tamanho do maior período
    }

    public void flag3() {

        // Para termos o dia com mais casos:
        int mais_casos = casos[0];
        for (int i = 1; i < casos.length; i++) {
            if (casos[i] > mais_casos)
                mais_casos = casos[i];
        }

        int altura = mais_casos / 100;

        for (int i = altura; i > 0; i--) {
            for (int j = 0; j < dias; j++) {
                // Se o casos[dia] / 100 >= altura; é um #
                if (casos[j] / 100 >= i)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }

    }

}