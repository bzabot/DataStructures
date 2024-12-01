class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(1);
        list.addFirst(6);
        list.addFirst(6);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);

        System.out.println(list);

        list.removeT(6);

        System.out.println(list);

    }
}