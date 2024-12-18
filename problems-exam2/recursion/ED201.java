import java.util.Scanner;

public class ED201 {
    static Scanner sc;
    static int target;
    static int closestSoFar = 0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        // Leitura das variáveis
        target = sc.nextInt();
        int n = sc.nextInt();
        int[] durations = new int[n];
        for (int i = 0; i < n; i++) {
            durations[i] = sc.nextInt();
        }

        sets(durations);
        System.out.println(closestSoFar);

    }

    public static void sets(int[] durations) {
        boolean[] used = new boolean[durations.length];
        sets(durations, 0, used);
    }

    private static void sets(int[] durations, int cur, boolean[] used) {
        // Caso base (cur == length)
        if (cur == durations.length) {
            // Preciso descobrir qual o valor mais proximo do target sem ultrapassar o valor
            int soma = 0;
            for (int i = 0; i < cur; i++) {
                if (used[i])
                    soma += durations[i];
            }

            if (soma < target) {
                if (target - closestSoFar > target - soma)
                    closestSoFar = soma;
            }

        } else {
            used[cur] = true;
            sets(durations, cur + 1, used);
            used[cur] = false;
            sets(durations, cur + 1, used);
        }

    }
}