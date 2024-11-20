
public class SinglyLinkedList2<T> {
   private Node<T> first; // Primeiro no da lista
   private int size; // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList2() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty())
         return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty())
         return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   public T get(int pos) {
      if (isEmpty() || pos >= size)
         return null;
      Node<T> cur = first;
      for (int i = 0; i < pos; i++) {
         cur = cur.getNext();
      }
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty())
         return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty())
         return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i = 0; i < size - 2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   public T remove(int pos) {
      if (isEmpty() || pos >= size)
         return null;
      T ans = get(pos);
      // Se for o primeiro
      if (pos == 0) {
         removeFirst();

      }
      // Se for o último
      else if (pos == size - 1) {
         removeLast();

      } else { // Se for um intermediário
         Node<T> cur = first;
         for (int i = 0; i < pos - 1; i++) {
            cur = cur.getNext(); // Nó anterior ao nó que queremos
         }
         // O anterior passa apontar para o posterior:
         cur.setNext(cur.getNext().getNext());

      }
      size--;
      return ans;
   }

   public SinglyLinkedList2<T> copy() {
      if (isEmpty())
         return null;
      SinglyLinkedList2<T> ans = new SinglyLinkedList2<>();
      Node<T> cur = first;
      while (cur != null) {
         ans.addLast(cur.getValue());
         cur = cur.getNext();
      }
      return ans;
   }

   public void duplicate() {
      Node<T> cur = first;
      while (cur != null) {
         Node<T> newNode = new Node<T>(cur.getValue(), cur.getNext());
         cur.setNext(newNode);
         cur = cur.getNext().getNext();
         size++;
      }

   }

   public int count(T value) {
      Node<T> cur = first;
      int ans = 0;
      while (cur != null) {
         if (cur.getValue().equals(value))
            ans++;
         cur = cur.getNext();
      }
      return ans;
   }

   public void removeAll(T value) {

      if (isEmpty())
         return;

      // Caso primeiros elementos
      while (first != null && first.getValue().equals(value)) {
         first = first.getNext();
         size--;
      }

      // Um elemento até o final
      Node<T> cur = first;
      Node<T> prev = cur;
      while (cur != null) {
         // Se o pointeiro atual for igual ao elem buscado, aponta ao proximo
         if (cur.getValue().equals(value)) {
            prev.setNext(cur.getNext());
            size--;
            // Se o elemento atual não for igual ao buscado, prev passa a ser o atual
         } else {
            prev = cur;
         }

         cur = cur.getNext();
      }

   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null)
            str += ",";
      }
      str += "}";
      return str;
   }
}