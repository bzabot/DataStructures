import java.util.Scanner;

public class ED231 {
    static Scanner s = new Scanner(System.in);
    static int nDias;
    static int[] nCasos;

    public static void main(String[] args) {
        nDias = s.nextInt();
        nCasos = new int[nDias];
        for (int i = 0; i < nDias; i++) {
            nCasos[i] = s.nextInt();
        }
        int flag = s.nextInt();
        if (flag == 1)
            flag1();
        if (flag == 2)
            flag2();
        if (flag == 3)
            flag3();
    }

    // Valor minimo e máximo de novos casos por dia
    static void flag1() {
        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nDias - 1; i++) {
            maxSoFar = Math.max(nCasos[i + 1] - nCasos[i], maxSoFar);
            minSoFar = Math.min(nCasos[i + 1] - nCasos[i], minSoFar);
        }
        System.out.println(minSoFar + " " + maxSoFar);
    }

    static void flag2() {
        double[] percentuais = new double[nDias - 1];
        for (int i = 0; i < nDias - 1; i++) {
            percentuais[i] = (nCasos[i + 1] - nCasos[i]) * 100.0 / nCasos[i];
        }
        printFlag2(percentuais);
    }

    static void printFlag2(double[] percentuais) {
        int nBaixas = 0;
        int maiorPeriodo = 0;
        int tamPeriodoAtual = 0;
        for (int i = 0; i < percentuais.length; i++) {
            if (percentuais[i] < 5) {
                nBaixas++;
                tamPeriodoAtual = 0;
                while (percentuais[i] < 5) {
                    i++;
                    tamPeriodoAtual++;
                    if (i >= percentuais.length)
                        break;
                }
                maiorPeriodo = Math.max(tamPeriodoAtual, maiorPeriodo);
            }
        }
        System.out.println(nBaixas + " " + maiorPeriodo);
    }

    static void flag3() {
        int[] altura = new int[nDias];
        int maxSoFar = 0;
        for (int i = 0; i < nDias; i++) {
            altura[i] = nCasos[i] / 100;
            maxSoFar = Math.max(maxSoFar, altura[i]);

        }

        // 0, 1, 2, 4, 6, 9, 13
        for (int linha = maxSoFar; linha > 0; linha--) {
            for (int coluna = 0; coluna < nDias; coluna++) {
                // System.out.println("altura: " + altura[coluna]);
                // System.out.println("linha: " + linha);
                if (altura[coluna] >= linha)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

}