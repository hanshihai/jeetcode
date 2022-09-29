package jeet.code;

public class ListNodeCollection {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   public static ListNode min(ListNode node) {
        if(null == node) {
            return node;
        }
        ListNode result = node;
        ListNode current = result.next;
        while(current != null) {
            if (result.val > current.val) {
                result = current;
            }
            current = current.next;
        }
        return result;
   }

   public static ListNode sort(ListNode node) {
        ListNode min = min(node);
        ListNode current = node;
        while (null != min) {
            if (current.val > min.val) {
                int temp = current.val;
                current.val = min.val;
                min.val = temp;
            }
            current = current.next;
            min = min(current);
        }
        return node;
   }

   public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode current = null;
        if (null == list1 && null == list2) {
            return null;
        }
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        ListNode a = list1;
        ListNode b = list2;

        while (a != null && b != null) {
            ListNode point = null;
            if (a.val <= b.val) {
                point = a;
                a = a.next;
            } else {
                point = b;
                b = b.next;
            }
            if (result == null) {
                result = point;
            }
            if (current == null) {
                current = point;
            } else {
                current.next = point;
                current = current.next;
            }
        }

        if (a != null) {
           current.next = a;
        } else if (b != null) {
            current.next = b;
        }
        return result;
   }

}
