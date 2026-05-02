/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        ListNode head1 = l1;
        ListNode head2 = l2;

        int carry = 0;
        int sum = 0;
        while(head1 != null || head2 != null){
            sum = carry;
            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            ptr.next = newNode;
            ptr = ptr.next;
        }
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            ptr.next = newNode;
        }
        return dummy.next;
    }
}
