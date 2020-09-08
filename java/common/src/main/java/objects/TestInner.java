package objects;

/**
 * Created by cznno
 * Date: 18-6-1
 */
public class TestInner {
    private String aa;
    private int bb;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "{" +
                "\"aa\":\"" + aa + "\"" +
                ",\"bb\":" + bb +
                "}";
    }
}
