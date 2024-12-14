
class EX206 {
    public static void main(String[] args){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printList(node1);


        printList(reverse1(node1));
    }

    public static ListNode reverseRec(ListNode head){
        if(head == null) return prev;
        

        return head.next;
    }

    public static ListNode reverse1(ListNode head){
        // List size = 0 or size = 1;
        if(head == null || head.next == null) return head;
        // List size = 2
        if(head.next.next == null) {
            ListNode second = head.next;
            second.next = head;
            head.next = null;
            return second;
        }
        // List size >= 3
        ListNode L = head;
        ListNode M = head.next;
        ListNode R = head.next.next;
        while(R != null){
            if(L == head) L.next = null;
            M.next = L;
            L = M;
            M = R;
            R = R.next;
        }
        if(R == null){
            M.next = L;
        }

        return M;
    }

    public static void printList(ListNode first){
        ListNode curr = first;
        while(curr.next != null){
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}