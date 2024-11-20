class TestSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList2<Integer> list = new SinglyLinkedList2<>();

        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(11);
        list.addFirst(1);
        list.addFirst(1);

        System.out.println(list);
        list.removeAll(1);
        System.out.println(list);
        System.out.println(list.size());

    }
}