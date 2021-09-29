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
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * LEETCODE SOLUTION
 */
class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
        var first = head;
        var second = head;
        
        for(int index = 0; index < n - 1; index++) second = second.next; 
        
        while(second.next != null){
            
            second = second.next;
            var current = first.next;
            
            if(second.next == null){
                first.next = second;
                current.next = null;
                current = null;
                break;
            }
            
            first = first.next;
            
        }
        
        return head;
        
    }
    
}
