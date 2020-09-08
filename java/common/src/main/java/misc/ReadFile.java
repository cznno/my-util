package misc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static misc.Time.timeCost;

/**
 * Created by cznno
 * Date: 18-4-13
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        final ReadFile rf = new ReadFile();
        long start = System.nanoTime();
        rf.bufferedReader(path);
        System.out.print("bufferedReader:");
        timeCost(start);

        start = System.nanoTime();
//        rf.scanner(path);
        System.out.print("scanner:");
        timeCost(start);

        start = System.nanoTime();
        rf.inputStream(path);
        System.out.print("inputStream:");
        timeCost(start);

        start = System.nanoTime();
        rf.streamRead(path);
        System.out.print("streamRead:");
        timeCost(start);

        start = System.nanoTime();
        rf.files(path);
        System.out.print("files:");
        timeCost(start);
    }

    void bufferedReader(String path) {
//        File file = new File(path);
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void scanner(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
//        sc.useDelimiter("\\Z");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    void inputStream(String path) throws IOException {
        String result;
        FileInputStream fis = new FileInputStream(path);
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        reader.close();
        System.out.println(result);
    }

    void streamRead(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void files(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
    }
}
