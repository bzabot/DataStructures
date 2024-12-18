// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Geracao de permutacoes
// Ultima alteracao: 10/05/2019
// -----------------------------------------------------------

public class TestPerm {
	// Escrever todos as permutacoes do array v[]
	static void permutations(int v[]) {
		boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
		int perm[] = new int[v.length]; // permutacao actual
		goPerm(0, v, used, perm); // chamar funcao recursiva
	}

	// Gera todos os subconjuntos a partir da posicao 'cur'
	static void goPerm(int cur, int v[], boolean used[], int perm[]) {
		if (cur == v.length) { // Caso base: terminamos a permutacao
			for (int i = 0; i < v.length; i++) // Escrever a permutacao
				System.out.print(v[perm[i]] + " ");
			System.out.println();
		} else { // Se nao terminamos, continuar a gerar
			for (int i = 0; i < v.length; i++) // Tentar todos os elementos
				if (!used[i]) {
					used[i] = true;
					perm[cur] = i;
					goPerm(cur + 1, v, used, perm);
					used[i] = false;
				}
		}
	}

	// -----------------------------------------------------------

	public static void main(String[] args) {
		int v[] = { 1, 2, 3 }; // Inicializacao de array

		permutations(v);
	}
}
