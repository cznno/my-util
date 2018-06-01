package objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by cznno
 * Date: 18-6-1
 */
class CloneTest {

    @Test
    void deepCopyTest() throws ReflectiveOperationException {
        final TestClass testClass = new TestClass();
        final TestInner testInner = new TestInner();
        testInner.setAa("aaac");
        testInner.setBb(343);
        testClass.setA("bbb");
        testClass.setB(2323);
        testClass.setInner(testInner);

        final TestClass foo = Clone.deepCopy(testClass, TestClass.class);
        System.out.println(foo);
//        assertEquals(foo, testClass);
        testInner.setBb(5555);
//        assertEquals(foo, testClass);
    }

    @Test
    void foo() throws ReflectiveOperationException {
       final String s="abcd";
        final String s1 = Clone.deepCopy(s, String.class);
        System.out.println(s1);
    }
}