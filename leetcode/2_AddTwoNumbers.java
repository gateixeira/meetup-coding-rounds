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
    public ListNode addTwoNumbersPrev(ListNode l1, ListNode l2) {
        
        ListNode temp1 = new ListNode();
        temp1.next = l1;

        int carry = 0;

        while (l1 != null && l2 != null) {

            int temp = l1.val + l2.val + carry;
            l1.val = temp % 10;
            carry = temp/10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            
            int temp = l1.val + carry;
            l1.val = temp % 10;
            carry = temp/10;
            
            l1 = l1.next;
        }
        
        while (l2 != null) {

            int temp = l2.val + carry;
            ListNode n = new ListNode(temp % 10, null);
            l1 = n;
            carry = temp/10;
            
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            l1 = temp1.next;
            while (l1.next != null)
                l1 = l1.next;
            
            l1.next = new ListNode(1);
        }

        return temp1.next;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode();
        ListNode helper = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            int temp = val1 + val2 + carry;
            result.next = new ListNode(temp % 10);
            carry = temp/10;
            
            if (l1 != null)
                l1 = l1.next;
            
            if (l2 != null)
                l2 = l2.next;

            result = result.next;
        }

        return helper.next;
    }
}