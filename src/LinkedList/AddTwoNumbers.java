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

import java.math.BigInteger;

class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String first = "";
        String second = "";
        
        while(l1 != null){
            first = l1.val + first;
            l1 = l1.next;
        }
        
        while(l2 != null){
            second = l2.val + second;
            l2 = l2.next;
        }
        
        String result = (new BigInteger(first).add(new BigInteger(second))).toString();
        
       
        ListNode newNode = new ListNode(result.charAt(0) - '0');
        
        for(int index = 1; index < result.length(); index++){
            newNode = new ListNode(result.charAt(index) - '0' , newNode);
        }
        
        return newNode;
    }
    
}
