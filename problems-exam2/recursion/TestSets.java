// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Geracao de subconjuntos
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

public class TestSets {

   // Escrever todos os subconjuntos do array v[]
   static void sets(int v[]) {
      // array de booleanos para representar o conjunto
      boolean used[] = new boolean[v.length];
      goSets(0, v, used); // chamar funcao recursiva
   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static void goSets(int cur, int v[], boolean used[]) {
      if (cur == v.length) { // Caso base: terminamos o conjunto
         // Escrever conjunto
         System.out.print("Set:");
         for (int i = 0; i < v.length; i++)

            System.out.print(" " + used[i]);
         System.out.println();
      } else { // Se nao terminamos, continuar a gerar
         used[cur] = true; // Subconjuntos que incluem o elemento actual
         goSets(cur + 1, v, used);// Chamada recursiva
         used[cur] = false; // Subconjuntos que nao incluem o el. actual
         goSets(cur + 1, v, used);// Chamada recursiva
      }
   }

   // -----------------------------------------------------------

   public static void main(String[] args) {
      int v[] = { 4, 6, 8 }; // Inicializacao de array

      sets(v);
   }
}
