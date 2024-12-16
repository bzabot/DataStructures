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

   // Verificar se árvore é estrita
   public boolean strict() {
      return strict(root);
   }

   private boolean strict(BTNode<T> n) {
      if (n == null)
         return true;
      if ((n.getLeft() != null && n.getRight() == null) || (n.getLeft() == null && n.getRight() != null))
         return false;
      return strict(n.getLeft()) && strict(n.getRight());
   }

   // --------------------------------------------------------

   // Percorrer um certo caminho
   public T path(String C) {
      return path(root, C);
   }

   private T path(BTNode<T> n, String C) {
      BTNode<T> cur = n;
      if (C.equals("R"))
         return root.getValue();
      for (String charac : C.split("")) {
         if (charac.equals("D"))
            cur = cur.getRight();
         if (charac.equals("E"))
            cur = cur.getLeft();

      }
      return cur.getValue();
   }

   // --------------------------------------------------------

   // Mostrar todos os nós de um mesmo nível
   public int nodesLevel(int k) {
      return nodesLevel(root, k, 0);
   }

   private int nodesLevel(BTNode<T> n, int k, int acLevel) {
      if (n == null)
         return 0;
      if (acLevel == k && n != null)
         return 1;
      return nodesLevel(n.getRight(), k, acLevel + 1) + nodesLevel(n.getLeft(), k, acLevel + 1);
   }

   // --------------------------------------------------------

   // Devolver a quantidade de nós "internos"
   public int internal() {
      return internal(root);
   }

   private int internal(BTNode<T> n) {
      if (n == null)
         return 0;
      if (n.getRight() != null || n.getLeft() != null)
         return 1 + internal(n.getRight()) + internal(n.getLeft());
      return 0;
   }

   // --------------------------------------------------------

   // Cortar a árvore a partir de uma profundidade
   public void cut(int d) {
      if (d <= 0) {
         root = null;
         return;
      }
      cut(root, d, 0);

   }

   private void cut(BTNode<T> n, int d, int acLevel) {
      BTNode<T> cur = n;
      if (cur == null)
         return;
      if (acLevel == d - 1) {
         cur.setLeft(null);
         cur.setRight(null);
         return;
      }
      cut(cur.getLeft(), d, acLevel + 1);
      cut(cur.getRight(), d, acLevel + 1);
   }

   // --------------------------------------------------------

   // Retornar array com número máximo de nós em um nível e número de níveis com
   // essa qntd
   public int[] maxLevel() {
      int[] n_nodes = new int[depth() + 1];
      maxLevel(root, 0, n_nodes);

      int maxSoFar = n_nodes[0];
      for (int i : n_nodes) {
         if (i > maxSoFar)
            maxSoFar = i;
      }

      int[] ans = new int[2];
      ans[0] = maxSoFar;
      for (int i = 0; i < n_nodes.length; i++) {
         if (n_nodes[i] == maxSoFar)
            ans[1] += 1;
      }
      return ans;
   }

   private void maxLevel(BTNode<T> n, int level, int[] n_nodes) {
      if (n == null)
         return;
      n_nodes[level] += 1;
      maxLevel(n.getLeft(), level + 1, n_nodes);
      maxLevel(n.getRight(), level + 1, n_nodes);
   }

   // --------------------------------------------------------

   // Contar o número de filhos unicos
   public int count() {
      return count(root);
   }

   private int count(BTNode<T> n) {
      if (n == null)
         return 0;
      if ((n.getRight() != null && n.getLeft() == null) || (n.getRight() == null && n.getLeft() != null)) // é um filho
                                                                                                          // unico
         return 1 + count(n.getLeft()) + count(n.getRight());
      return count(n.getLeft()) + count(n.getRight());
   }

   // --------------------------------------------------------

   // Devolver o level mais baixo que contenha um nó de certo valor
   public int level(T v) {
      boolean[] contains = new boolean[depth() + 1];
      level(root, v, 0, contains);

      for (int i = 0; i < contains.length; i++) {
         if (contains[i])
            return i;
      }

      return -1;

   }

   private void level(BTNode<T> n, T v, int level, boolean[] contains) {
      if (n == null)
         return;
      if (n.getValue() == v)
         contains[level] = true;
      level(n.getLeft(), v, level + 1, contains);
      level(n.getRight(), v, level + 1, contains);

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
