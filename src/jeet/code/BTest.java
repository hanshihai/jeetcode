package jeet.code;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BTest {

    public static int triangle(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 0;
        }else if(a==b && b==c) {
            return 2;
        }
        if(a+b>c && a+c>b && b+c>a) {
            return 1;
        }
        return 0;
    }

    public static List<Integer> deltaArray(int[] array) {
        if(array == null || array.length == 0) {
            return new ArrayList();
        }
        List<Integer> result = new ArrayList<>();
        if(array.length == 1) {
            result.add(array[0]);
            return result;
        }

        Integer temp = array[0];
        boolean start = true;
        for(int a:array) {
            if(start) {
                result.add(temp);
                start = false;
            }else{
                int delta = a - temp;
                temp = a;
                result.add(delta);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        assertThat(2, is(BTest.triangle(3,3,3)));
        assertThat(1, is(BTest.triangle(3,4,6)));
        assertThat(0, is(BTest.triangle(3,5,9)));
        BTest.deltaArray(new int[] {100, 50, 25, 12, 6, 3}).stream().forEach(i -> System.out.print(i + " "));
    }
}
