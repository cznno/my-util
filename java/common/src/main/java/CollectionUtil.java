import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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
     * @param collection consumer要执行的参数
     * @param consumer   执行以list为参数的方法，如xxxDAO.insertOne(Object obj);
     * @param <T>        参数的类型
     */
    public static <T> void doIfNotEmpty(Collection<T> collection, Consumer<Collection<T>> consumer) {
        if (!CollectionUtil.isNullOrEmpty(collection)) {
            consumer.accept(collection);
        }
    }

    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 如果为空返回true, 如果不为空返回false
     */
    public static boolean isNullOrEmpty(Collection collection) {
        return null == collection || collection.size() == 0;
    }

    /**
     *
     * @param set
     * @param <T>
     * @return
     */
    public static <T> Set<T> nullToEmpty(Set<T> set) {
        //noinspection unchecked
        return set == null ? Collections.EMPTY_SET : set;
    }

    /**
     * 如果List是null，返回空List。避免NPE。
     * 可以用在循环中，如:<br/>
     * for (final Object o : nullToEmpty(aList)) {
     * // do something
     * }
     *
     * @param list list
     * @param <T>  list的类型
     * @return 如果list是null，返回空list。如果不是，返回原list。
     */
    public static <T> List<T> nullToEmpty(List<T> list) {
        //noinspection unchecked
        return list == null ? Collections.EMPTY_LIST : list;
    }
}
