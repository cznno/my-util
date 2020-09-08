package objects;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by cznno Date: 18-6-1
 */
public class Clone {

    static <T> T deepCopy(T origin, Class clazz)
            throws ReflectiveOperationException {
        final Field[] fields = clazz.getDeclaredFields();
        if (clazz.isPrimitive()) {
            return origin;
        }
        final Class<?> aClass = Class.forName(clazz.getName());
        final Object copy = aClass.newInstance();
        for (Field f : fields) {
            final Field modifiers = f.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
//            if (Modifier.isFinal(f.getModifiers()))
//                continue;
            f.setAccessible(true);
            final Class<?> type = f.getType();
            final Object o = f.get(origin);
            if (type.isPrimitive()) {
                f.set(copy, o);
            } else if (type.isArray()) {
                if (null == o)
                    continue;
                int length = Array.getLength(o);
                Object array = Array.newInstance(type.getComponentType(), length);
                for (int i = 0; i < length; i++) {
                    Object arrayElement = Array.get(o, i);
                    final Object o1 = deepCopy(arrayElement, o.getClass().getComponentType());
                    Array.set(array, i, o1);
                }
                System.out.println(copy.getClass().getName());
                System.out.println(array.getClass().getName());
                f.set(copy, array);
            } else {
                final Object o1 = deepCopy(o, type);
                f.set(copy, o1);
            }
        }
        return (T) copy;
    }
}
