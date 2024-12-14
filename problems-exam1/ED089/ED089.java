import java.util.Arrays;
import java.util.Scanner;

public class ED089 {
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int n_companies = std.nextInt();
        int n_flag = std.nextInt();
        std.nextLine();

        Taxes list = new Taxes(n_companies, n_flag);
        list.readData(std);
        list.sum();
        list.answer();

        std.close();

    }

}

class Taxes {
    private int companies;
    private int flag;
    private int[] taxes;
    private int[] areas;
    private int[] sum;

    Taxes(int n_companies, int n_flag) {
        companies = n_companies;
        flag = n_flag;
    }

    public void readData(Scanner scn) {
        taxes = new int[companies * 2];
        areas = new int[companies];
        int j = 0;
        for (int i = 0; i < companies; i++) {
            // Skip unwanted lines
            scn.nextLine(); // NIF
            scn.nextLine(); // Name
            scn.nextLine(); // Area economica
            int area = Integer.parseInt(scn.nextLine());
            areas[i] = area;
            taxes[j] = area;
            taxes[j + 1] = Integer.parseInt(scn.nextLine());
            j += 2;
        }

    }

    public void sum() {
        sum = new int[companies];
        Arrays.sort(areas);
        // Iterate through areas array [10, 10, 15, 20]
        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < taxes.length; j++) {
                if (taxes[j] == areas[i]) {
                    sum[i] += taxes[j + 1];
                }
            }
        }
    }

    public void answer() {
        // Itera atraves do areas
        if (flag == 1) {
            for (int i = 0; i < areas.length; i++) {
                // Se não for a posição 0 e o valor for igual ao valor do anterior, vai ao
                // proximo loop
                // Para não imprimir o mesmo valores duas vezes
                if (i > 0 && areas[i] == areas[i - 1]) {
                    continue;
                } else {
                    System.out.println(output1(i));
                }
            }
            // Se a flag for 0, imprime a quantidade de elementos unicos no areas
        } else if (flag == 0) {
            System.out.println("" + output2());
        }
    }

    public String output1(int pos) {
        return areas[pos] + " " + sum[pos];
    }

    public int output2() {
        int count = 0;
        for (int i = 0; i < areas.length; i++) {
            // Se não for a posição 0 e o valor for igual ao valor do anterior, vai ao
            // proximo loop
            // Para não imprimir o mesmo valores duas vezes
            if (i > 0 && areas[i] == areas[i - 1]) {
                continue;
            } else {
                count++;
            }
        }
        return count;

    }
}