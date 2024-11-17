import java.util.Scanner;

public class ED004 {
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		Game g = new Game(n);
		g.read(stdin);
		g.check();

		//System.out.println(g);
		stdin.close();
	}
}

class Game{
	private int n;
	private char game[][];

	Game(int size){
		n = size;
		game = new char[n][n];
	}

	void read(Scanner in){
		for (int i=0; i<n; i++){
			String linha = in.next();
			for(int j=0; j<n; j++){
				game[i][j] = linha.charAt(j); // Na linha i, divide o caracter;
			}
		}
	}

	public void check(){
		// Checar se há vencedor
		String result = "";
		int n_X = 0;
		int n_O = 0;
		// Verificar as linhas:
		for (int i=0; i<n; i++){ 
			verify(i, 0, 0, 1); // verifica as linhas
		}

		if(!finished()) {
			System.out.println("Jogo imcompleto");
		}
		else {
			System.out.println("Empate");
		}
	}

	void verify(int y, int x, int incy, int incx){
		if(game[y][x] == '.') return; // interrompe o ciclo se começar com ponto
		for(int i=0, yy=y, xx=x; i<n; i++, yy+=incy, xx+=incx){
			if(game[y][x] != game[yy][xx]) return; // Interrompe o ciclo se achar algo diferente do anterior
		}
		win(game[y][x]);
	}

	void win(char player){
		System.out.println("Ganhou o " + player);
		System.exit(0);
	}

	boolean finished(){
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				if(game[i][j] == '.') return false;
			}
		}
		return true;
	}

	// Permite printar o tabuleiro do jogo
	public String toString(){
		 String ans = "";

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				ans += game[i][j] + " ";
			}
			ans += "\n";
		}

		return ans;
	}


}