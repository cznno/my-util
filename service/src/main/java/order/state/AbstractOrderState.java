package order.state;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public abstract class AbstractOrderState implements OrderState {

    @Override
    public boolean equals(Object obj) {
        return this.getClass().getName().equals(obj.getClass().getName());
    }
}
