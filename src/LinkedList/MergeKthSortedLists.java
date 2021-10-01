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
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 *
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head;
        ListNode temp;

        List<Integer> arrList = new ArrayList();

        var emptyList = new ListNode().next;

        if(lists.length == 0) return emptyList;

        temp = head = new ListNode();
        var min = 0;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] == emptyList) continue;
            else{
                var l1 = lists[i];

                while (l1 != null) {
                    arrList.add(l1.val);

                    if(l1.val < min) min = l1.val;

                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                }
            }
        }

        Collections.sort(arrList);

        head = temp;
        temp = head = new ListNode(min);

        for(int i = 0; i < arrList.size(); i++){
            temp.next = new ListNode(arrList.get(i));
            temp = temp.next;
        }


        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {

        ListNode head;
        ListNode temp;

        var emptyList = new ListNode().next;

        if(lists.length == 0) return emptyList;

        temp = head = new ListNode();
        var min = 0;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] == emptyList) continue;
            else{
                var l1 = lists[i];

                while (l1 != null) {
                    if(l1.val < min) min = l1.val;

                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                }
            }
        }

        ListNode sorted = head.next;
        head = temp;
        temp = head = new ListNode(min);

        for(int i = -10000; i < 10000; i++){

            var init = sorted;

            while(init != null){

                if(init.val == i)
                    temp.next = new ListNode(i);

                if(temp.next != null) temp = temp.next;

                init = init.next;
            }

            init = sorted;
        }


        return head.next;
    }
}