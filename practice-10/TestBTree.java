import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      // Escrever resultado de chamada a alguns metodos

      System.out.println("n nodes 0 = " +  t.nodesLevel(0));
      System.out.println("n nodes 1 = " +  t.nodesLevel(1));
      System.out.println("n nodes 2 = " +  t.nodesLevel(2));
      System.out.println("n nodes 3 = " +  t.nodesLevel(3));



   }
}
