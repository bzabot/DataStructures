class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);

        System.out.println(list);
        System.out.println(list.count(6));

        list.duplicate();
        System.out.println(list);
        System.out.println(list.count(6));
        System.out.println(list.count(1));
        System.out.println(list.count(25));

    }
}