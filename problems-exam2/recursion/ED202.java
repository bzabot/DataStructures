import java.util.Scanner;

class ED202 {

    static Scanner s = new Scanner(System.in);
    static float[][] distances;
    static int[] path;
    static float shortestPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = s.nextInt();
        // path = new int[n];

        for (int i = 0; i < n; i++) {
            s.next();
        }

        int[] places = new int[n - 1];
        for (int i = 1; i < n; i++) {
            places[i - 1] = i;
        }

        distances = new float[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = s.nextFloat();
            }
        }

        permutations(places);

        System.out.printf("%.2f\n", shortestPath);

    }

    static float calcDist(int[] p) {
        float dist = 0.00f;

        dist += distances[0][p[0]];

        for (int i = 0, j = 1; j < p.length; i++, j++) {
            dist += distances[p[i]][p[j]];

        }
        dist += distances[p[p.length - 1]][0];

        return dist;

    }

    static void permutations(int v[]) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length]; // permutacao actual
        goPerm(0, v, used, perm); // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) { // Caso base: terminamos a permutacao
            int[] acPerm = new int[v.length];

            for (int i = 0; i < v.length; i++) { // Escrever a permutacao
                // Escrever a permutacao
                acPerm[i] = v[perm[i]];

            }
            shortestPath = Math.min(shortestPath, calcDist(acPerm));

        } else { // Se nao terminamos, continuar a gerar
            for (int i = 0; i < v.length; i++) // Tentar todos os elementos
                if (!used[i]) {
                    used[i] = true;
                    perm[cur] = i;
                    goPerm(cur + 1, v, used, perm);
                    used[i] = false;
                }
        }
    }

}