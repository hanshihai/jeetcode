import java.time.LocalTime;

public class Clock {

    public static void clock() throws InterruptedException{
        int start = -1;
        while(true) {
            LocalTime time = LocalTime.now();
            if (start != time.getHour() && time.getMinute() == 0) {
                onClock(time.getHour());
                start = time.getHour();
            }
            System.out.print(".");
            Thread.sleep(30000);
        }
    }

    private static void onClock(int time) {
        System.out.println();
        int formatTime = time;
        if(formatTime == 0) {
            formatTime = 12;
        }
        if(formatTime == -1) {
            System.out.println("Half");
        }else{
            for(int i=0;i<formatTime;i++) {
                System.out.print("Down ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            Clock.clock();
        }catch(Exception e) {
            System.out.println("get error : "+e.getMessage());
            System.exit(1);
        }
    }
}
