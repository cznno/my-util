package objects;

/**
 * Created by cznno
 * Date: 18-6-1
 */
public class TestClass {
    private String a;
    private int b;
    private TestInner inner;
    private char[] chars;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public TestInner getInner() {
        return inner;
    }

    public void setInner(TestInner inner) {
        this.inner = inner;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "{" +
                "\"a\":\"" + a + "\"" +
                ",\"b\":" + b +
                ",\"inner\":" + inner +
                "}";
    }
}
