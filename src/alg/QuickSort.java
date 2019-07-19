package alg;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private long[] theArray;
    private int len;

    public QuickSort(long[] e) {
        if(e != null && e.length > 0) {
            theArray = e;
            len = e.length;
        }else{
            len = 0;
        }
    }

    public void print(){
        System.out.println("--- start to print ----");
        Arrays.stream(theArray).forEach(e -> System.out.print(e + " "));
        System.out.println("--- end ----");
    }

    private void swap(int a, int b) {
        long temp = theArray[a];
        theArray[a] = theArray[b];
        theArray[b] = temp;
    }

    public void quickSort(int left, int right) {
        if(right - left <= 0) {
            return;
        }

        long pivot = theArray[right];
        int partition = partitionIt(left, right, pivot);
        quickSort(left, partition - 1);
        quickSort(partition + 1, right);
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftP = left-1;
        int rightP = right;

        while(true) {
            while(theArray[++leftP] < pivot) {
                ;
            }
            while(theArray[--rightP] > pivot) {
                ;
            }

            if(leftP >= rightP) {
                break;
            }else{
                swap(leftP, rightP);
            }
        }
        swap(leftP, right);
        System.out.println("--- the pivot : " + leftP + " with value : " + pivot);
        print();
        return leftP;
    }

    public static void main(String[] args) {
        long[] elements = new long[18];
        for(int i=0;i<18;i++) {
            elements[i] = (int)(Math.random()*99);
        }
        QuickSort sort = new QuickSort(elements);
        sort.print();
        sort.quickSort(0, 17);
    }
}
