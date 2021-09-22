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
        
        ListNode newNode = new ListNode(head.val);
        
        for(int index = 0; index < n - 1; index++) second = second.next; 
        
        int counter = 1;
        
        while(second.next != null){
            
            second = second.next;
            var current = newNode;
            
            if(second.next == null){
//                 first.next = second;
//                 for(int index = 0; index < counter - 1; index++) current = current.next;
//                 System.out.println(current.val);
                
//                 // newNode.val = second.val;
                
                // newNode = new ListNode(second.val, newNode);
                break;
            }
            
            first = first.next;
            
            newNode = new ListNode(first.val, newNode);
            counter++;
 
        }
        
        
        return newNode;
    }
    
}
