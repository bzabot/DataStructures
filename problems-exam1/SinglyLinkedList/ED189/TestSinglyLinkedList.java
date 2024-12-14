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
        list.remove(5);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(2);

        System.out.println(list);

        list.remove(6);

    }
}