package output;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author cznno
 * Date: 2019/3/12
 */
public final class CSVUtil {

    Class<?> clazz;

    Field[] fields;

    public CSVUtil(Class<?> clazz) {
        this.clazz = clazz;
        this.fields = clazz.getDeclaredFields();
    }



    public void write(Collection<?> collection, String pathStr) throws IllegalAccessException, IOException {
        if (collection.isEmpty()) {return;}

        StringBuilder sb = new StringBuilder();

        for (final Field field : this.fields) {
            field.setAccessible(true);
            sb.append(field.getName()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        for (final Object o : collection) {
            for (final Field field : this.fields) {
                sb.append("\"")
                  .append(field.get(o).toString().replace("\"", "\"\""))
                  .append("\"")
                  .append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        Path path = Paths.get(pathStr);
        byte[] strToBytes = sb.toString().getBytes();
        Files.write(path, strToBytes);
    }
}
