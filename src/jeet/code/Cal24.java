package jeet.code;

import java.util.ArrayDeque;

public class Cal24 {

    public enum SIGN {
        ADD, SUB, MUL, DIV
    }

    private ArrayDeque<Integer> numberQueue = new ArrayDeque<>();
    private ArrayDeque<SIGN> signQueue = new ArrayDeque<>();

    public Cal24(int[] numbers, SIGN[] signs) {
        System.out.println(" --- ---- ----");
        for(int n: numbers) {
            numberQueue.add(n);
            System.out.print(n+" ");
        }
        System.out.println("\n     ----    ");
        for(SIGN s: signs) {
            signQueue.add(s);
            System.out.print(s+" ");
        }
        System.out.println("\n --- ---- ----");
    }

    public int sign(int a, int b, SIGN sign) {
        switch (sign) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MUL:
                return a*b;
            case DIV:
                if( a % b == 0) {
                    return a / b;
                }else{
                    return -1;
                }
        }
        return -1;
    }

    public int calculate() {
        if(numberQueue.isEmpty() || numberQueue.size() == 1 || signQueue.isEmpty()) {
            return -1;
        }
        int a = numberQueue.pop();
        while(!numberQueue.isEmpty() && !signQueue.isEmpty()) {
            int b = numberQueue.pop();
            SIGN sign = signQueue.pop();
            a = sign(a, b, sign);
            if(a == -1) {
                return a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Cal24 cal = new Cal24(new int[] {2,1,2,8}, new SIGN[]{SIGN.SUB, SIGN.ADD, SIGN.MUL});
        System.out.println(" " + cal.calculate());
    }
}
