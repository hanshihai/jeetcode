import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ClearDisk {

    private static long fileSize = 1024 * 1024 * 10;
    private static int bufferSize = 1024;
    private static String postix = ".txt";
    private static byte[] buffer;

    public static String generateFileName() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("GMT+8"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-SSS", Locale.CHINA);
        return formatter.format(now) + postix;
    }

    public static void clear(Path root) throws IOException {
        long iterators = fileSize / bufferSize;
        buffer = new byte[bufferSize];
        Path file = root.resolve(generateFileName());
        if(!Files.exists(file)) {
            Files.createFile(file);
            if(Files.isWritable(file)) {
                int iterator = 0;
                while(iterator < iterators) {
                    Files.write(file, buffer, StandardOpenOption.APPEND);
                    iterator++;
                }
            }
        }
        Files.delete(file);
        Files.createFile(file);
        for(int i=0;i<buffer.length;i++) {
            buffer[i] = (byte) ~buffer[i];
        }
        if(Files.isWritable(file)) {
            int iterator = 0;
            while(iterator < iterators) {
                Files.write(file, buffer, StandardOpenOption.APPEND);
                iterator++;
            }
        }
    }

    public static void main(String[] args) {
        if(args == null || args.length < 1) {
            System.out.println("*** Usage: java ClearDisk path ***");
            System.out.println("*** such as java ClearDisk C:\\repository\\jeetcode\\out ***");
            System.exit(0);
        }
        Path root = Paths.get(args[0]);
        try{
            ClearDisk.clear(root);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
