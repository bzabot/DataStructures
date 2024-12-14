class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(6);
        list.addFirst(4);
        list.addFirst(2);
        System.out.println(list);
        System.out.println(list.get(1));

    }
}