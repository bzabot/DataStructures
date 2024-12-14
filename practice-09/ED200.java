import java.util.Scanner;

public class ED200{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i =0; i<n; i++){
            Check game = new Check(in);
            System.out.println(game.findBiggest());
        }


    }

}

class Check{
    Scanner in;
    int rows, cols;
    char[][] board;
    boolean[][] visited;

    Check(Scanner s){
        in = s;


        rows = in.nextInt();
        cols = in.nextInt();
        board = new char[rows][cols];
        visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++){
            board[i] = in.next().toCharArray();
        }
    }

    // Tamanho da mancha que inclui posicao (y,x)
    public int t(int y, int x) {
        if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
        if (visited[y][x]) return 0;  // Caso base: celula ja visitada
        if (board[y][x] == '.') return 0; // Caso base: celula vazia
        int count = 1;        // celula nao vazia
        visited[y][x] = true; // marcar como visitada
        count += t(y-1, x);   // Adicionando celulas nao vizinhas
        count += t(y+1, x);
        count += t(y, x+1);
        count += t(y, x-1);
        count += t(y+1, x-1);
        count += t(y+1, x+1);
        count += t(y-1, x-1);
        count += t(y-1, x+1);
        return count;
    }


    public int findBiggest(){
        int biggest = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(!visited[i][j]) biggest = Math.max(t(i, j), biggest);

            }
        }
        return biggest;
    }

    public void printGame(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}