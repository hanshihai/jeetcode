public class GuessIt {

    public static int MAX = 999;
    public static int THRESHOLD = MAX / 2;

    public static void guess(int target) {
        int index = 1;
        int min = 0;
        int max = MAX;
        int num = (min + max) / 2;
        while(num != target && index < THRESHOLD) {
            System.out.println("round "+index+" and the guess is "+num);
            if(num < target) {
                min = num;
            }else if(num > target) {
                max = num;
            }
            num = (max + min) / 2;
            index += 1;
        }
        if(num == target) {
            System.out.println("Bigoo, the guess is out :" + num + " with round "+index);
        }
        if(index >= THRESHOLD) {
            System.out.println("Failed to find it...");
        }
    }

    public static void main(String[] args) {
        int target  = 0;
        while(target == 0) {
            target = (int)(Math.random() * MAX);
        }
        System.out.println("the target number is : " + target);
        GuessIt.guess(target);
    }
}
