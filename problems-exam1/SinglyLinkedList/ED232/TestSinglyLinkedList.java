class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(1);

        System.out.println(list);

        list.removeEl(1);

        System.out.println(list);

    }
}