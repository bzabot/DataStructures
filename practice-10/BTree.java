public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

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
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
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
      if (n==null) return;
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
      if (n==null) return;
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

   // --------------------------------------------------------

   public void printDFS() {
      // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
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
   // --------------------------------------------------------
   public int numberLeafs(){
      return numberLeafs(root);
   }
   private int numberLeafs(BTNode<T> n){
      if(n==null) return 0;
      if(n.getLeft() == null && n.getRight() == null) return 1; // É uma folha
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
   }

   // --------------------------------------------------------

   public boolean strict(){
      return strict(root);
   }
   private boolean strict(BTNode<T> n){
      // CB
      if(n.getLeft() == null && n.getRight() == null) return true;
      // R
      if(n.getLeft() != null && n.getRight() == null) return false;
      if(n.getRight() != null && n.getLeft() == null) return false;

      return(strict(n.getLeft()) &&  strict(n.getRight()));

   }

   // --------------------------------------------------------

   public T path(String s){
      if(s.equals("R")) return root.getValue();
      String[] s2 = s.split("");
      BTNode<T> ans = root;
      for(String c : s2){
         if(c.equals("D"))  ans = ans.getRight();
         if(c.equals("E"))  ans = ans.getLeft();
      }
      return ans.getValue();
   }

   // --------------------------------------------------------

   public int nodesLevel(int k){
      if(k==0) return 1;
      int[] n_nodes = new int[k];
      return nodesLevel(root, n_nodes, 0);
   }
   private int nodesLevel(BTNode<T> n, int[] n_nodes, int cur){

      if(n.getRight() != null) n_nodes[cur+1] += 1;
      if(n.getLeft() != null) n_nodes[cur+1] += 1;
      if(n_nodes.length - 2 != )

   }

}
