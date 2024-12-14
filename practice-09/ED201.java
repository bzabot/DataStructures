import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ED201 {
    static int min_diff = Integer.MAX_VALUE; // Minimum difference
    static List<Integer> closestSubset = new ArrayList<>(); // Closest subset to the target

    // Function to generate all subsets of the array v[] using dynamic programming
    static void findClosestSubset(int[] v, int target) {
        int n = v.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (v[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - v[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest subset sum to the target
        int closestSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                closestSum = j;
                break;
            }
        }

        // Retrieve the closest subset
        List<Integer> currentSubset = new ArrayList<>();
        int w = closestSum;
        for (int i = n; i > 0 && w > 0; i--) {
            if (!dp[i - 1][w]) {
                currentSubset.add(v[i - 1]);
                w -= v[i - 1];
            }
        }

        closestSubset = currentSubset;
        min_diff = Math.abs(target - closestSum);
    }

    // Main function
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt(); // Target sum
        int n = in.nextInt(); // Number of elements in the array
        int[] tam = new int[n];

        for (int i = 0; i < n; i++) {
            tam[i] = in.nextInt();
        }

        findClosestSubset(tam, target);
        System.out.println(closestSubset.stream().mapToInt(Integer::intValue).sum());
    }
}