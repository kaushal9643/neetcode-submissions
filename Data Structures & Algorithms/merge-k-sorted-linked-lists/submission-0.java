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
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = new ListNode(head1.val);
                head1 = head1.next;
            }
            else{
                tail.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            tail = tail.next;
        }

        while(head1 != null){
            tail.next = new ListNode(head1.val);
            head1 = head1.next;
            tail = tail.next;
        }

        while(head2 != null){
            tail.next = new ListNode(head2.val);
            head2 = head2.next;
            tail = tail.next;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode result = lists[0];
        for(int i=1; i<lists.length; i++){
            result = merge(result, lists[i]);
        }
        return result;
    }
}
