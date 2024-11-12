// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Implementa o TAD conjunto usando um array como lista de elementos
// Ultima alteracao: 10/03/2018
// -----------------------------------------------------------

public class ED247 {
   public static void main(String[] args) {
      IntSet s1 = new ArrayListIntSet(100);
      IntSet s2 = new ArrayListIntSet(100);

      for (int i = 1; i <= 5; i++)
         s1.add(i);
      System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

      for (int i = 3; i <= 7; i++)
         s2.add(i);
      System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

      IntSet s3 = s1.intersection(s2);
      System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

      IntSet s4 = s2.intersection(s1);
      System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

      System.out.println("s1.equals(s2) = " + s1.equals(s2));
      System.out.println("s3.equals(s4) = " + s3.equals(s4));

   }
}

class ArrayListIntSet implements IntSet {
   private int size; // Numero de elementos do conjunto
   private int elem[]; // Array que contem os elementos em si

   ArrayListIntSet(int maxSize) {
      elem = new int[maxSize];
      size = 0;
   }

   public boolean add(int x) {
      if (!contains(x)) {
         if (size == elem.length)
            throw new RuntimeException("Maximum size of set reached");
         elem[size] = x;
         size++;
         return true;
      }
      return false;
   }

   public boolean remove(int x) {
      if (contains(x)) {
         int pos = 0;
         while (elem[pos] != x)
            pos++;
         size--;
         elem[pos] = elem[size]; // Trocar ultimo elemento
         return true; // com o que se removeu
      }
      return false;
   }

   public boolean contains(int x) {
      for (int i = 0; i < size; i++)
         if (elem[i] == x)
            return true;
      return false;
   }

   public void clear() {
      size = 0;
   }

   public int size() {
      return size;
   }

   public boolean equals(IntSet s) {
      if (this.size != s.size()) {
         return false;
      }

      for (int i = 0; i < size; i++) {

         if (!s.contains(elem[i])) {
            return false;
         }
      }
      return true;
   }

   public IntSet intersection(IntSet s) {
      ArrayListIntSet intersection = new ArrayListIntSet(100);
      for (int i = 0; i < size; i++) {
         if (s.contains(elem[i])) {
            intersection.add(elem[i]);
         }
      }
      return intersection;
   }

   @Override
   public String toString() {
      String res = "{";
      for (int i = 0; i < size; i++) {
         if (i > 0)
            res += ",";
         res += elem[i];
      }
      res += "}";
      return res;
   }
}
