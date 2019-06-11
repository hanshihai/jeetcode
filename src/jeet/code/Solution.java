package jeet.code;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public Solution() {}
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int delta = 0;
        ListNode l1T = l1;
        ListNode l2T = l2;

        ListNode node = new ListNode(0);
        ListNode pointer = node;

        while(l1T != null || l2T != null) {
            int sum = delta;
            if(l1T != null) {
                sum += l1T.val;
            }
            if(l2T != null) {
                sum += l2T.val;
            }
            if(sum > 9) {
                delta = 1;
                sum  = sum % 10;
            }else{
                delta = 0;
            }
            ListNode temp = new ListNode(sum);
            pointer.next = temp;
            pointer = pointer.next;
            if(l1T != null) {
                l1T = l1T.next;
            }
            if(l2T != null) {
                l2T = l2T.next;
            }
        }
        if(delta == 1) {
            ListNode tail = new ListNode(1);
            pointer.next = tail;
        }
        return node.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node11 = s.new ListNode(9);

        ListNode node21 = s.new ListNode(1);
        ListNode node22 = s.new ListNode(9);
        ListNode node23 = s.new ListNode(9);

        node21.next = node22;
        node22.next = node23;

        s.addTwoNumbers(node11, node21);
    }
}
