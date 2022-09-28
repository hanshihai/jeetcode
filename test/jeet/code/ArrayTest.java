package jeet.code;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by hans on 3/21/2018.
 */
public class ArrayTest {

    @Test
    public void testRemoveDuplicates() {
        Array array = new Array();

        int[] nums1 = new int[] {1,1,2};
        assertThat(2, is(array.removeDuplicates(nums1)));

        int[] nums2 = new int[] {1,2,2,3,5};
        assertThat(4, is(array.removeDuplicates(nums2)));

        int[] nums3 = new int[] {1,1,2,2,2,4};
        assertThat(3, is(array.removeDuplicates(nums3)));

        int[] nums4 = new int[] {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5};
        assertThat(5, is(array.removeDuplicates(nums4)));
    }

    @Test
    public void testRotate() {
        Array array = new Array();

        int[] num1 = new int[] {1,2,3,4,5,6,7};
        assertThat(new int[]{5,6,7,1,2,3,4}, is(array.rotate(num1, 3)));

        int[] num2 = new int[] {1, 2};
        assertThat(new int[]{2,1}, is(array.rotate(num2, 1)));
    }

    @Test
    public void testContainsDuplicate() {
        Array array = new Array();

        int[] num1 = new int[] {1,2,3,4,5,6,7};
        assertThat(false, is(array.containsDuplicate(num1)));

        int[] num2 = new int[] {1,2,2,4,5,6,7};
        assertThat(true, is(array.containsDuplicate(num2)));
    }

    @Test
    public void testSingleNumber() {
        Array array = new Array();

        int[] num1 = new int[] {1,1,3,4,3,6,7,7,6};
        assertThat(4, is(array.singleNumber(num1)));

        int[] num2 = new int[] {1};
        assertThat(1, is(array.singleNumber(num2)));

        int[] num3 = new int[] {1,1,4};
        assertThat(4, is(array.singleNumber(num3)));
    }

    @Test
    public void testMoveZeroes() {
        Array array = new Array();

        int[] num1 = new int[] {0,1,0,3,12};
        assertThat(new int[] {1,3,12,0,0}, is(array.moveZeroes(num1)));
    }
}
