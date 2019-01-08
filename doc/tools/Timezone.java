import java.text.MessageFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Timezone {

    public static void main(String[] args) throws Exception {

        System.out.println("Please input the source time zone and target time zone, such as GMT+8 UTC:");
        Scanner in = new Scanner(System.in);

        while(true) {
            String input = in.nextLine();
            if("q".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
                System.out.println("quit.");
                System.exit(0);
            }

            String[] zones = input.split(" ");

            ZonedDateTime sourceZone = ZonedDateTime.now(ZoneId.of(zones[0]));
            ZonedDateTime targetZone = sourceZone.withZoneSameInstant(ZoneId.of(zones[1]));

            String pattern = ">>>> the time in source zone is {0} {1} and the time in target zone is {2} {3}.";
            Object[] parameters = new Object[4];
            parameters[0] = sourceZone.toLocalDate();
            parameters[1] = sourceZone.toLocalTime();
            parameters[2] = targetZone.toLocalDate();
            parameters[3] = targetZone.toLocalTime();

            String message = new MessageFormat(pattern, Locale.US).format(parameters);
            System.out.println(message);
            System.out.println("\nplease input new one:");
        }
    }
}
