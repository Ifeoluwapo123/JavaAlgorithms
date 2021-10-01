/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Input: head = []
 * Output: []
 *
 * Input: head = [1]
 * Output: [1]
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        var emptyList = new ListNode().next;

        if(head == emptyList || head.next == null) return head;

        var current = head;

        while(current != null){
            if(current.next == null) break;

            var tempVal = current.val;
            current.val = current.next.val;
            current.next.val = tempVal;

            current = current.next.next;
        }

        return head;
    }
}