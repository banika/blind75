package blind.linkedlist;

/**
 * Created by Anindita Banik on 8/1/22.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow)
                return true;
        }

        return false;
    }
}
