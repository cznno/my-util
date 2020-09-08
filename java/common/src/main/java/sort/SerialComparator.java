package sort;

import java.util.Comparator;

/**
 * 对类似1.23.4.56这样的字符排序
 * Created by cznno
 * Date: 18-4-26
 */
public class SerialComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] serial1 = o1.split("\\.");
        String[] serial2 = o2.split("\\.");
        for (int i = 0; i < serial1.length; i++) {
            if (Integer.valueOf(serial1[i]) > Integer.valueOf(serial2[i]))
                return 1;
            else if (Integer.valueOf(serial1[i]) < Integer.valueOf(serial2[i]))
                return -1;
        }
        return 0;
    }
}
