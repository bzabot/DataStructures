import java.util.Scanner;

public class ED088 {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int nRows = stdin.nextInt();
        int nColumns = stdin.nextInt();
        int nRodadas = stdin.nextInt();

        Game g = new Game(nRows, nColumns, nRodadas);
        g.read(stdin);
        g.jogo();
        System.out.println(g);

        stdin.close();

    }

}

class Game {
    private char game[][];
    private int nRows;
    private int nCols;
    private int nRodadas;
    private int[][] counter;

    Game(int rows, int cols, int rodadas) {
        nRows = rows;
        nCols = cols;
        nRodadas = rodadas;
        game = new char[nRows][nCols];
    }

    // Função que recebe o input
    void read(Scanner stdin) {
        for (int i = 0; i < nRows; i++) {
            String linha = stdin.next();
            for (int j = 0; j < nCols; j++) {
                game[i][j] = linha.charAt(j);
            }
        }
    }

    void jogo() {
        for (int i = 0; i < nRodadas; i++) {
            rodada();
        }
    }

    // Uma rodada:
    void rodada() {
        // Inicializa o contador do número de vizinhos de cada célula
        counter = initalizeCounter(nRows, nCols);

        // Percorre a matriz, quando encontra uma célula viva, soma um a todos os
        // vizinhos
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (game[i][j] == 'O') {
                    loop_neighbours(counter, i, j);
                }
            }
        }

        // Atualiza o tabuleiro para a próxima rodada
        attGame();

    }

    // Atualiza o tabuleiro com base no contador
    void attGame() {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                // Se é uma célula viva e tem menos que dois ou mais que três vizinhos -> morre
                if (game[i][j] == 'O' && (counter[i][j] < 2 || counter[i][j] > 3)) {
                    game[i][j] = '.';
                    // Se é uma célula morta e tem três vizinhos -> vive
                } else {
                    if (counter[i][j] == 3) {
                        game[i][j] = 'O';
                    }
                }

            }
        }
    }

    // Retorna uma matriz de 0's do tamanho do tabuleiro
    public int[][] initalizeCounter(int nRows, int nCols) {
        return new int[nRows][nCols];
    }

    // Checa o número de vizinhos
    void loop_neighbours(int[][] contador, int row, int column) {
        // Faz o loop por todas as células vizinhas
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                int neighbourRow = row + i;
                int neighbourColumn = column + j;

                // Quando a célula vizinha é a célula analisada -> continue
                if (neighbourRow == row && neighbourColumn == column) {
                    continue;
                }

                // Checar se a célula analisada pertence a matrix
                // Sem essa checagem, poderiamos tentar adicionar 1 a um idx fora do tabuleiro
                if (checkCell(neighbourRow, neighbourColumn, nRows, nCols)) {
                    contador[neighbourRow][neighbourColumn]++;
                }
            }
        }
    }

    // Retorna true se uma célula faz parte da matriz
    private boolean checkCell(int row, int column, int n_rows, int n_columns) {
        return (row >= 0 && row < n_rows && column >= 0 && column < n_columns);
    }

    // Permite printar o tabuleiro do jogo
    public String toString() {
        String ans = "";

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                ans += game[i][j];
            }
            if (i < nRows - 1) {
                ans += "\n";
            }

        }

        return ans;
    }
}
