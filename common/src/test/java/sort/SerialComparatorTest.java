package sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by cznno
 * Date: 18-4-26
 */
class SerialComparatorTest {

    private final List<String> strings = new ArrayList<>(Arrays.asList(
            "1.7.0.211",
            "5.1.0.1",
            "2.3.0.290",
            "2.1.21.23",
            "2.1.3.78",
            "1.8.22.289",
            "3.17.24.129",
            "3.12.13.287",
            "3.14.13.281",
            "1.10.0.1"));

    private final List<String> sorted = Arrays.asList(
            "1.7.0.211",
            "1.8.22.289",
            "1.10.0.1",
            "2.1.3.78",
            "2.1.21.23",
            "2.3.0.290",
            "3.12.13.287",
            "3.14.13.281",
            "3.17.24.129",
            "5.1.0.1"
    );

    @Test
    void compare() {
        strings.sort(new SerialComparator());
        for (int i = 0; i < strings.size(); i++) {
            assertEquals(strings.get(i), sorted.get(i));
        }
    }
}