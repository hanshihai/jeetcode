package jeet.code;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import jeet.code.ListNodeCollection.*;
public class ListNodeCollectionTest {

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
