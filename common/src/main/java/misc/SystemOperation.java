package misc;

import java.io.*;

/**
 * Created by cznno
 * Date: 18-4-17
 */
public class SystemOperation {
    public static PrintWriter out;

    /**
     * @link https://stackoverflow.com/questions/13530429/read-realtime-output-of-a-command
     * @link https://www.experts-exchange.com/questions/20496876/Java-Programming-Runtime-exec-getInputStream-realTime-data.html
     * @param command cli command
     */
    public static void runCommand(String command) {
        try {
            final Process exec = Runtime.getRuntime().exec(command);
            InputStream inputStream = exec.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                java.lang.System.out.println(line); // it prints all at once after command has been executed.
            }
            exec.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
