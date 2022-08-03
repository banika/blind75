package blind.linkedlist;

/**
 * Created by Anindita Banik on 8/1/22.
 * https://www.youtube.com/watch?v=xRYPjDMSUFw&t=646s
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode l1 = head; // head of first half
        ListNode prev = null; // tail of first half
        ListNode slow = head; // head of second half
        ListNode fast = head; // tail of second half

        //get middle
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next = null;

        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    void merge(ListNode l1, ListNode l2){
        while(l1!=null){
            ListNode l1_next=l1.next;
            ListNode l2_next=l2.next;

            l1.next = l2;
            if(l1_next==null)
                break;

            l2.next=l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
