package misc.threadpool;

import java.util.concurrent.*;

/**
 * Created by cznno
 * Date: 18-4-24
 */
public class ThreadPool {

    private Thread threads[];
    private boolean interrupted = false;
    private BlockingQueue<Callable<?>> taskQueue = new ArrayBlockingQueue<>(10);
    private BlockingQueue<Object> resultQueue = new PriorityBlockingQueue<>();

    public ThreadPool(int size) {
        threads = new Worker[size];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker();
            threads[i].start();
        }
    }

    public synchronized void submit(Runnable task) {
        taskQueue.add((Callable<Void>) () -> {
            task.run();
            return null;
        });
    }

    public synchronized <T> void submit(Callable<T> task) {
        taskQueue.add(task);
    }

    public synchronized Object get() {
        return resultQueue.poll();
    }

    public synchronized Object get(long timeout, TimeUnit unit) throws InterruptedException {
        return resultQueue.poll(timeout, unit);
    }

    public synchronized boolean terminate() {
        int aliveThreads = threads.length;
        this.interrupted = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
        while (aliveThreads >= 0)
            for (Thread thread : threads) {
                if (!thread.isAlive())
                    aliveThreads--;
            }
        return true;
    }

    class Worker extends Thread {

        Object result = null;

        public void run() {
            while (!interrupted) {
                Callable task = taskQueue.poll();
                if (task != null) {
                    try {
                        result = task.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                        result = e;
                    } finally {
                        resultQueue.offer(result);
                    }
                }
            }
        }
    }
}
