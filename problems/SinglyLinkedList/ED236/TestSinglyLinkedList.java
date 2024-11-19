class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(10);
        list.addFirst(8);
        list.addFirst(6);
        list.addFirst(4);
        list.addFirst(2);

        System.out.println(list);
        list.shift(3);

        System.out.println(list);

    }
}