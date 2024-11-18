import java.util.Scanner;

class ED183 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        s.nextLine();

        Estatisticas est = new Estatisticas(total);
        est.input(s);

        float avg = est.avg();
        int amplitude = est.amplitude();
        System.out.format("%.2f \n", avg);
        System.out.println(amplitude);

    }

}

class Estatisticas {
    int[] list;
    float total;
    float sum;

    Estatisticas(int n) {
        total = n;
        list = new int[n];
    }

    public void input(Scanner s) {
        for (int i = 0; i < total; i++) {
            list[i] = s.nextInt();
        }
    }

    public float avg() {
        for (int i = 0; i < total; i++) {
            sum += list[i];
        }
        return sum / total;
    }

    public int amplitude() {
        int b = list[0];
        int s = list[0];
        for (int i = 0; i < total; i++) {
            if (list[i] > b)
                b = list[i];
            if (list[i] < s)
                s = list[i];
        }
        return b - s;
    }

}