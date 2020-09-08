package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Stop Watch
 * not thread safe
 * Created by cznno
 * Date: 18-4-13
 */
public class StopWatch {

    private long startTime;
    private boolean isPause = true;
    private boolean isStop = false;
    private List<Long> splitTime = new ArrayList<>();

    public void start() {
        if (this.isPause && !this.isStop) {
            this.startTime = System.nanoTime();
            this.isPause = false;
        }
    }

    public long stop() {
        if (!this.isPause) {
            splitTime.add(System.nanoTime() - startTime);
            this.isPause = true;
            this.isStop = true;
        }
        return splitTime.get(splitTime.size() - 1);
    }

    public void pause() {
        if (!this.isPause) {
            splitTime.add(System.nanoTime() - startTime);
            this.isPause = true;
        }
    }

    public void reset() {
        splitTime.clear();
    }
}
