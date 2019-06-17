package jeet.code;

public class SearchLogN {

    /*
    * return index when it's found; return -1 if no found
     */
    public static int search(int[] array, int s) {
        if(array == null) {
            return -1;
        }
        if(array != null && array.length == 1) {
            return array[0] == s ? 0 : -1;
        }

        int n = 0;
        int m = array.length - 1;
        while(n<=m) {
            if(array[n] == s) {
                return n;
            }else if(array[m] == s){
                return m;
            }else if(n == m || n+1 == m) {
                return -1;
            }
            int index = (n+m) / 2;
            if(array[index] == s) {
                return index;
            }else if(array[index] < s) {
                n = index;
            }else if(array[index] > s) {
                m = index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("-1 -> " + SearchLogN.search(new int[]{10, 20, 30, 40, 50 ,60 }, 32));
        System.out.println("-1 -> " + SearchLogN.search(new int[]{10, 20, 30, 40, 50 }, 32));
        System.out.println("2 -> " + SearchLogN.search(new int[]{10, 20, 32, 40, 50 ,60 }, 32));
        System.out.println("2 -> " + SearchLogN.search(new int[]{10, 20, 32, 40, 50 }, 32));
        System.out.println("5 -> " + SearchLogN.search(new int[]{10, 20, 30, 40, 50, 80}, 80));
        System.out.println("0 -> " + SearchLogN.search(new int[]{10, 20, 30, 40, 50, 80}, 10));
    }
}
