package misc.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by cznno
 * Date: 18-4-24
 */
public class ThreadTest {
    static final Runnable R1 = () -> {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running " + "output: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Test
    void threadPoolTest() throws InterruptedException {
        ThreadPool tp = new ThreadPool(5);
        Callable<Integer> cb = () -> 1 + 1;
        tp.submit(cb);

        assertEquals(tp.get(1, TimeUnit.SECONDS), 2);
        assertEquals(tp.terminate(), true);
    }
}
