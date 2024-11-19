class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(11);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);

        System.out.println(list);
        list.removeAll(1);
        System.out.println(list);

    }
}