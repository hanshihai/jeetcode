public class JumpIt {

    public static String REPLACER_A = "Fizz";
    public static String REPLACER_B = "Buzz";
    public static int JUMP_A = 3;
    public static int JUMP_B = 5;

    public static void jump(int max) {
        System.out.print("0,");
        for(int i=1;i<max;i++) {
            if(i%JUMP_A == 0 && i%JUMP_B ==0) {
                System.out.print(REPLACER_A + REPLACER_B);
            }else if(i%JUMP_A == 0){
                System.out.print(REPLACER_A);
            }else if(i%JUMP_B == 0) {
                System.out.print(REPLACER_B);
            }else{
                System.out.print(i);
            }
            System.out.print(",");
        }
    }

    public static void main(String[] args) {
        JumpIt.jump(100);
    }
}
