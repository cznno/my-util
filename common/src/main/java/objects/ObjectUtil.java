package objects;

/**
 * 对象用工具<br/>
 * 如果用Objects就可以解决问题的，不要用这个类。
 *
 * @author cznno
 * Date: 2019/1/11
 */
public final class ObjectUtil {

    /**
     * 检查所有的参数中是否至少有一个为null。
     *
     * @param objects 参数对象
     * @return 如果全部对象都不是null，返回false。
     * 如果有一个对象是null，返回true。如果不传对象，返回false;
     */
    public static boolean atLeastOneNull(Object... objects) {
        return !allNotNull(objects);
    }

    /**
     * 检查所有的参数是否为not null。
     *
     * @param objects 参数对象
     * @return 如果全部对象都不是null，返回true。
     * 如果有一个对象是null，返回false。如果不传对象，返回true;
     */
    public static boolean allNotNull(Object... objects) {
        for (final Object o : objects) {
            if (null == o) {
                return false;
            }
        }
        return true;
    }
}
