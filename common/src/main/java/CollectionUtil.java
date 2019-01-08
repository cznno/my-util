import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * 用于集合的工具类
 *
 * @author cznno
 */
public final class CollectionUtil {
    private CollectionUtil() {}

    /**
     * 以非空集合为参数，如果集合非空就执行传入的方法。
     * 可以避免一些情况下的NPE：如
     *
     * @param list     consumer要执行的参数
     * @param consumer 执行以list为参数的方法，如xxxDAO.insertOne(Object obj);
     * @param <T>      参数的类型
     */
    public static <T> void doIfNotEmpty(List<T> list, Consumer<List<T>> consumer) {
        if (!CollectionUtil.isNullOrEmpty(list)) {
            consumer.accept(list);
        }
    }

    /**
     * 判断集合是否为空
     *
     * @param list 集合
     * @return 如果为空返回true, 如果不为空返回false
     */
    public static boolean isNullOrEmpty(Collection list) {
        return null == list || list.size() == 0;
    }
}
