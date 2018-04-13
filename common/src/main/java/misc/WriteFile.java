package misc;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cznno
 * Date: 18-4-13
 */
public class WriteFile {

    static void bufferedWriter1(String outPath, String outStr) throws IOException {
        Path path = Paths.get(outPath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(outStr);
        }
    }

    public void bufferedWriter2(String outPath, String outStr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outPath));
        writer.write(outStr);
        writer.close();
    }

    public void bufferedWriter3(String outPath, String outStr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outPath, true));
        writer.append(outStr);
        writer.close();
    }

    public void fileWriter(String outPath, String outStr) throws IOException {
        FileWriter fileWriter = new FileWriter(outPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(outStr);
        printWriter.close();
    }

    public void outputStream(String outPath, String outStr) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(outPath);
        outputStream.write(outStr.getBytes());
        outputStream.close();
    }

    public void dataOutputStream(String outPath, String outStr) throws IOException {
        FileOutputStream fos = new FileOutputStream(outPath);
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        outStream.writeUTF(outStr);
        outStream.close();
    }

    public void fileChannel(String outPath, String outStr) throws IOException {
        RandomAccessFile stream = new RandomAccessFile(outPath, "rw");
        FileChannel channel = stream.getChannel();
        byte[] strBytes = outStr.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();
    }

    public void randomAccessFile(String filename, int data, long position) throws IOException {
        RandomAccessFile rw = new RandomAccessFile(filename, "rw");
        rw.seek(position);
        int read = rw.read();
        rw.writeInt(data);
        rw.close();
    }

    /**
     * java 7
     */
    public void filesWrite(String outPath, String outStr) throws IOException {
        Files.write(Paths.get(outPath), outStr.getBytes());
    }

    public void temporaryFile(String outStr) throws IOException {
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(outStr);
        writer.close();
    }

    /**
     * 文件锁
     */
    public void fileLock(String outPath, String outStr) throws IOException {
        RandomAccessFile stream = new RandomAccessFile(outPath, "rw");
        FileChannel channel = stream.getChannel();

        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        stream.writeChars(outStr);
        if (lock != null) {
            lock.release();
        }

        stream.close();
        channel.close();
    }
}
