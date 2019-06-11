package jeet.code;

public class NumberSolution {
        private static int iterator = 0;
        public static int split(int n) {
            int sum = 0;
            int input = n;
            while(input > 9) {
                int splited = input % 10;
                input = input / 10;
                sum += splited * splited;
            }
            sum += input * input;
            return sum;
        }

        public static int calculate(int n) {
            if(iterator > 5) {return 0;}
            iterator++;
            int temp = split(n);
            if( temp == 1) {return temp;}
            if(temp > 1000) {return 0;}
            return calculate(temp);
        }
        public boolean isHappy(int n) {
            try{
                NumberSolution.iterator = 0;
                int result = NumberSolution.calculate(n);
                if(result == 1) {return true;}
            }catch(Throwable t){}

            return false;
        }

    public static int reverse(long x) {
        double max = Math.pow(2, 31) - 1;
        double min = -1 * Math.pow(2, 31);
        if(x < min || x > max) {return 0;}
        int result = 0;
        int sign = 1;
        int input = (int)x;
        if(x < 0) {
            sign = -1;
            input = input * sign;
        }

        int level = 1;
        while(input > 9) {
            int split = input % 10;
            input = input / 10;
            result = result * level + split;
            level = 10;
        }

        double up = (1d * result * level + input) * sign;
        if(up > Integer.MAX_VALUE || up < Integer.MIN_VALUE) {
            return 0;
        }
        result = result * level + input;
        return result * sign;
    }

    public static void main(String[] args) {
            System.out.println(NumberSolution.reverse(1534236469));
        System.out.println(NumberSolution.reverse(123));
        System.out.println(NumberSolution.reverse(3));
        System.out.println(NumberSolution.reverse(-3));
        System.out.println(NumberSolution.reverse(-12345));
    }
}

