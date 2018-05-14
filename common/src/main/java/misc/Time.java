package misc;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 时间相关的工具
 * Created by cznno
 * Date: 18-4-10
 */
public class Time {

    /**
     * 求时间差,并按指定单位返回
     *
     * @param date1    开始时间
     * @param date2    结束时间
     * @param timeUnit 单位
     * @return 时间差
     */
    public static long getTimeDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMS = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMS, TimeUnit.MILLISECONDS);
    }

    public static void timeCost(long start) {
        System.out.println("used:" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms");
    }

    /**
     * 获取本机的Unix时间
     */
    public static long getUnixTime() {
        return Instant.now().getEpochSecond();
        /*
        method 1:
        long unixTime = System.currentTimeMillis() /1000L;
        method 2:
        Date now = new Date();
        long unixTime = now.getTime() / 1000L;
        */
    }

    /**
     * 获取时区
     * @see <a href="https://coderanch.com/t/386398/java/System-Timezone">
     *     How to get System Timezone?</a>
     */
    public static void getTimezone(){
        TimeZone tz = Calendar.getInstance().getTimeZone();
        System.out.println(tz.getDisplayName());
        System.out.println(tz.getID());
    }
}
