// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {
      return root;
   }

   public void setRoot(BTNode<T> r) {
      root = r;
   }

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null)
         return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null)
         return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------

   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n == null)
         return false;
      if (n.getValue().equals(value))
         return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Contar o número de folhas
   public int numberLeafs() {
      return numberLeafs(root);
   }

   private int numberLeafs(BTNode<T> n) {
      if (n == null)
         return 0;
      if (n.getLeft() == null && n.getRight() == null)
         return 1;
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
   }

   // --------------------------------------------------------

   // Contar o número de folhas
   public int internal() {
      return internal(root);
   }

   private int internal(BTNode<T> n) {
      // Se for uma folha, não é nó interno
      if (n.getRight() == null && n.getLeft() == null)
         return 0;
      int count = 1;
      if (n.getRight() != null)
         count += internal(n.getRight());
      if (n.getLeft() != null)
         count += internal(n.getLeft());
      return count;
   }

   // --------------------------------------------------------

   // Remover todos os nós com profundidade maior ou igual a d
   public void cut(int d) {
      cut(root, d, 0);
   }

   private void cut(BTNode<T> n, int d, int cur) {
      if (n == null)
         return;
      if (cur == d - 1) {
         n.setRight(null);
         n.setLeft(null);
         return;
      }

      cut(n.getLeft(), d, cur + 1);
      cut(n.getRight(), d, cur + 1);
   }

   // --------------------------------------------------------

   // Remover todos os nós com profundidade maior ou igual a d
   public int[] maxLevel() {
      // Ideia: criar um array com o número de nos, os indices daquele array serão o
      // correspondente nível
      int[] nNodes = new int[depth() + 1];
      maxLevel(root, 0, nNodes);

      int[] ans = new int[2];
      int biggestSoFar = nNodes[0];
      for (int i : nNodes) {
         biggestSoFar = Math.max(i, biggestSoFar);
      }
      ans[0] = biggestSoFar;
      for (int i : nNodes) {
         if (i == biggestSoFar)
            ans[1] += 1;
      }
      return ans;

   }

   private void maxLevel(BTNode<T> n, int level, int[] nNodes) {
      if (n == null)
         return;
      nNodes[level] += 1;
      if (n.getLeft() != null) {
         maxLevel(n.getLeft(), level + 1, nNodes);
      }
      if (n.getRight() != null) {
         maxLevel(n.getRight(), level + 1, nNodes);
      }
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n == null)
         return;
      System.out.print(" " + n.getValue());
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n == null)
         return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n == null)
         return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");

      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // // --------------------------------------------------------

   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");

      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

}
