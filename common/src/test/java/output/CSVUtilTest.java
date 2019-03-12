package output;

import base.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cznno
 * Date: 2019/3/12
 */
class CSVUtilTest {

    @AfterAll
    static void deleteFiles() {
        File file = new File("test.csv");
        System.out.println("file deleted: " + file.delete());
    }

    @Test
    void write() throws IOException, IllegalAccessException {
        CSVUtil csvUtil = new CSVUtil(Person.class);
        List<Person> Persons = new ArrayList<>();
        Persons.add(new Person("a", 10, "aaa"));
        Persons.add(new Person("b", 12, "bbb"));
        Persons.add(new Person("c", 33, "cc\"cc"));
        csvUtil.write(Persons, "test.csv");
        List<String> strings = Files.readAllLines(Paths.get("test.csv"));
        strings.forEach(System.out::println);
    }
}