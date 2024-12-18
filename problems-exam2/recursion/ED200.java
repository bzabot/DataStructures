import java.util.Scanner;

public class ED200 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       for(int i = 0; i<n; i++){
           Game g = new Game(sc);
           System.out.println(g.size());
       }

       sc.close();
    }



}

class Game {
    int linhas;
    int colunas;
    char[][] grid;
    boolean[][] visited;

    Game(Scanner s){
        Scanner sc = s;
        linhas = sc.nextInt();
        colunas = sc.nextInt();
        grid = new char[linhas][colunas];
        visited = new boolean[linhas][colunas];

        for(int i = 0; i<linhas; i++){
            grid[i] = sc.next().toCharArray();
        }

    }

    public int size(){
        int maxSoFar = 0;
        for(int i = 0; i<linhas;i++){
            for(int j = 0; j<colunas; j++){
                if(!visited[i][j]){
                    maxSoFar = Math.max(check(i, j), maxSoFar);
                }
            }
        }

        return maxSoFar;
    }

    public int check(int y, int x) {
        if (x < 0 || y < 0 || y >= linhas || x >= colunas) return 0;
        if (visited[y][x]) return 0;
        if (grid[y][x] == '.') return 0;
        visited[y][x] = true;
        int count = 1;
        count += check(y - 1, x);   // Adicionando celulas nao vizinhas
        count += check(y + 1, x);
        count += check(y, x + 1);
        count += check(y, x - 1);
        count += check(y + 1, x - 1);
        count += check(y + 1, x + 1);
        count += check(y - 1, x - 1);
        count += check(y - 1, x + 1);
        return count;
    }


}