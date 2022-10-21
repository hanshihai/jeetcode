package jeet.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {

    @Test
    public void testMinimumTotal_Simple() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        sub.add(-10);
        triangle.add(sub);
        assertThat(-10, is(Triangle.minimumTotal(triangle)));
    }

    @Test
    public void testMinimumTotal_Normal() {
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[] sub_0 = new Integer[]{2};
        Integer[] sub_1 = new Integer[]{3, 4};
        Integer[] sub_2 = new Integer[]{6, 5, 7};
        Integer[] sub_3 = new Integer[]{4, 1, 8, 3};
        triangle.add(Arrays.asList(sub_0));
        triangle.add(Arrays.asList(sub_1));
        triangle.add(Arrays.asList(sub_2));
        triangle.add(Arrays.asList(sub_3));
        assertThat(11, is(Triangle.minimumTotal(triangle)));
    }
}
