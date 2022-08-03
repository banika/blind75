package blind.linkedlist;

/**
 * Created by Anindita Banik on 8/1/22.
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        ListNode slow=start, fast = start;
        slow.next=head;
        fast.next=head;;

        for(int i=1;i<=n+1;i++){
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode node = new ListNode(1);
        ListNode head = node;

        node.next = new ListNode(2);
        node = node.next;

        node.next = new ListNode(3);
        node = node.next;

        node.next = new ListNode(4);
        node = node.next;

        node.next = new ListNode(5);
        node = node.next;

        ListNode newNode = removeNthNodeFromEnd.removeNthFromEnd(new ListNode(1), 1);
        System.out.println(newNode);
    }
}
