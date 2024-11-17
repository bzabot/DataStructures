public class TestSinglyLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(42);
        list.addFirst(200);
        list.addFirst(42);
        list.addFirst(9999);
        list.addFirst(42);
        list.addFirst(200);
        list.addFirst(42);

        System.out.println(list);
        System.out.println(list.count(42));
        System.out.println(list.count(200));
        System.out.println(list.count(9999));
        System.out.println(list.count(1));

    }
}