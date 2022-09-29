package jeet.code;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import jeet.code.ListNodeCollection.*;
public class ListNodeCollectionTest {

    @Test
    public void testMin() {
        int[] values = new int[] {8, -4, -9, 3, 10};
        ListNode data = null;
        ListNode current = null;
        for(int i=0;i<values.length;i++) {
            ListNode node = new ListNodeCollection().new ListNode(values[i]);
            if (data == null) {
                data = node;
            }
            if (current != null) {
                current.next = node;
                current = node;
            } else {
                current = node;
            }
        }
        ListNode result = ListNodeCollection.min(data);
        assertThat(true, is(-9 == result.val));
    }

    @Test
    public void testSort() {
        int[] values = new int[] {8, -4, -9, 3, 10};
        ListNode data = null;
        ListNode current = null;
        for(int i=0;i<values.length;i++) {
            ListNode node = new ListNodeCollection().new ListNode(values[i]);
            if (data == null) {
                data = node;
            }
            if (current != null) {
                current.next = node;
                current = node;
            } else {
                current = node;
            }
        }
        ListNodeCollection.sort(data);
        assertThat(true, is(-4 == data.next.val));
    }

    @Test
    public void testMerge_empty() {
        ListNodeCollection.ListNode nodeA = null;
        ListNodeCollection.ListNode nodeB = null;

        ListNodeCollection.ListNode result = ListNodeCollection.merge(nodeA, nodeB);
        assertThat(true, is(null == result));
    }

    @Test
    public void testMerge_notEmpty() {
        ListNodeCollection.ListNode nodeA = new ListNodeCollection().new ListNode(2);
        ListNodeCollection.ListNode nodeB = new ListNodeCollection().new ListNode(6);

        ListNodeCollection.ListNode result = ListNodeCollection.merge(nodeA, nodeB);
        assertThat(true, is(result.val == 2));
    }
}
