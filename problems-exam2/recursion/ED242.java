import java.util.Scanner;

public class ED242 {

    static Scanner s;
    static int n;
    static boolean[][] map;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();

        map = new boolean[100][100];
        int linha = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            char[] c = line.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '#')
                    map[linha][i] = true;
            }
            linha++;
        }

        s.close();
    }

    static int n_lakes(boolean[][] lakes) {
        
    }

}