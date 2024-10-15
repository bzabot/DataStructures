import java.util.Scanner;

public class ED015 {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int input = 0;

        while (true) {
            int nRows = stdin.nextInt();
            int nColumns = stdin.nextInt();
            if (nRows == 0 && nColumns == 0) {
                break;
            }

            Game g = new Game(nRows, nColumns);
            g.read(stdin);
            g.readWords(stdin);
            g.check();

            input++;
            System.out.println("Input #" + input);
            System.out.println(g);
        }
        stdin.close();
    }

}

class Game {
    private char game[][];
    private int nRows;
    private int nCols;
    private String[] words;
    boolean[][] answer;

    Game(int rows, int cols) {
        nRows = rows;
        nCols = cols;
        game = new char[nRows][nCols];
        answer = new boolean[nRows][nCols];
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

    void readWords(Scanner stdin) {
        int nWords = stdin.nextInt();
        words = new String[nWords];
        for (int i = 0; i < nWords; i++) {
            words[i] = stdin.next();
        }
    }

    // Checa para todas as palavras passadas pelo Scanner
    void check() {
        for (String word : words) {
            search(word);
        }
    }

    // Percorre o tabuleiro, procurando a primeira letra da palavra
    // Se encontra, tenta procurar para os quatro lados a palavra
    void search(String word) {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (word.charAt(0) == game[i][j]) {
                    searchWord(word, i, j, 1, 0); // Para baixo
                    searchWord(word, i, j, 0, 1); // Para a direita
                    searchWord(word, i, j, -1, 0); // Para cima
                    searchWord(word, i, j, 0, -1); // Para esquerda
                }
            }
        }
    }

    // Tenta procurar a palavra, baseado num incremento em i ou em j
    boolean searchWord(String word, int i, int j, int inci, int incj) {
        // Loop por todas as letras da palavra, neste momento já que sabe que, no
        // primeiro loop, onde k = 0, a coordenada ii e jj será a primeira letra da
        // palavra

        for (int k = 0; k < word.length(); k++) {
            int ii = i + k * inci;
            int jj = j + k * incj;
            if (ii < 0 || ii >= nRows || jj < 0 || jj >= nCols || game[ii][jj] != word.charAt(k)) {
                return false; // Se está fora do tabuleiro ou a letra é diferente, retorna falso
            }
        }

        changeAnswer(word, i, j, inci, incj);
        return true;
    }

    // Muda o array answer, que contém falses para true onde a palavra foi
    // encontrada
    void changeAnswer(String word, int i, int j, int inci, int incj) {
        for (int k = 0; k < word.length(); k++) {
            answer[i][j] = true;
            i += inci;
            j += incj;
        }
    }

    // Printa o tabuleiro do jogo já formatado com pontos
    public String toString() {
        String ans = "";

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (answer[i][j]) {
                    ans += game[i][j];
                } else {
                    ans += ".";
                }
            }
            if (i < nRows - 1) {
                ans += "\n";
            }

        }

        return ans;
    }

}
