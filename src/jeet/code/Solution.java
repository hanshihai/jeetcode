package jeet.code;

import java.util.*;

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

    public ListNode reverse(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n || n == 1) {
            return head;
        }
        ArrayDeque<ListNode> queue = new ArrayDeque<>();
        List<ListNode> beginers = new ArrayList<>();
        ListNode start = new ListNode(-1);
        ListNode tail = null;
        start.next = head;
        beginers.add(start);
        int index = 0;
        while(start.next != null) {
            index++;
            ListNode temp = start.next;
            if(index < m) {
                beginers.add(temp);
            }else if(index >= m && index <n){
                queue.addFirst(temp);
            }else if(index == n) {
                queue.addFirst(temp);
                tail = temp.next;
                break;
            }
            start = start.next;
        }
        start = null;
        ListNode temp = null;
        for(ListNode node: beginers) {
            if(start == null) {
                start = node;
                temp = start;
            }else{
                temp.next = node;
                temp = node;
            }
        }
        while(!queue.isEmpty()) {
            ListNode p = queue.pop();
            temp.next = p;
            temp = p;
        }
        temp.next = tail;
        return start.next;
    }

    public static void testDqueue() {
        ArrayDeque<Integer> queue = new ArrayDeque();
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);
        while(!queue.isEmpty()) {
            System.out.print(queue.pop()+ " ");
        }
    }
    public ListNode replaceEachOther(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n || n == 1) {
            return head;
        }
        ListNode mBefore = null;
        ListNode nBefore = null;
        ListNode mNext = null;
        ListNode nNext = null;

        int index = 1;
        ListNode temp = head;
        if(m == 1) {
            mBefore = new ListNode(-1);
            mBefore.next = head;
        }

        while(temp.next != null) {
            index++;
            if(index == m) {
                mBefore = temp;
            }
            if(index == n) {
                nBefore = temp;
            }
            temp = temp.next;
        }
        if(mBefore == null) {
            mBefore = temp;
        }
        if(nBefore == null) {
            nBefore = temp;
        }

        if(n == (m+1)) {
            nNext = nBefore.next.next;
            ListNode mTemp = mBefore.next;
            ListNode nTemp = nBefore.next;
            mTemp.next = nNext;
            nTemp.next = mTemp;
            mBefore.next = nTemp;
            if(m == 1) {
                head = mBefore.next;
            }
        }else{
            nNext = nBefore.next.next;
            mNext = mBefore.next.next;
            ListNode mTemp = mBefore.next;
            ListNode nTemp = nBefore.next;
            mTemp.next = nNext;
            nTemp.next = mNext;
            nBefore.next = mTemp;
            mBefore.next = nTemp;

            if(m == 1) {
                head = mBefore.next;
            }
        }

        return head;
    }

    public boolean hasCycle(ListNode head) {
        LinkedHashMap<ListNode, Integer> map = new LinkedHashMap<>();
        int pos = -1;
        if(head != null) {
            ListNode temp = head;
            map.put(temp, -1);
            int index = 1;
            while(temp.next != null) {
                temp = temp.next;
                if(map.containsKey(temp)) {
                    pos = map.get(temp);
                    return true;
                }else{
                    map.put(temp, index);
                    index++;
                }
            }
        }
        return false;
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
        ListNode node1 = s.new ListNode(1);
        ListNode node2 = s.new ListNode(2);
        ListNode node3 = s.new ListNode(3);
        ListNode node4 = s.new ListNode(4);
        ListNode node5 = s.new ListNode(5);

       node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        s.reverse(node1, 2,4);
    }
}
