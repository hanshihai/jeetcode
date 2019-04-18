import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *   Run commands from java process:
 *   java ProcessExecute java -version
 */
public class ProcessExecute {

    public void execute(List<String> commands) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(commands);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        readStream(process.getInputStream());

        int result = process.waitFor();
        System.exit(result);
    }

    private void readStream(final InputStream in) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                    String line;
                    while((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        List<String> commands = new ArrayList<>();
        for(String s: args) {
            commands.add(s);
        }
        ProcessExecute execute = new ProcessExecute();
        execute.execute(commands);
    }
}
