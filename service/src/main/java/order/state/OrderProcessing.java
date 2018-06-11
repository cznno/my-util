package order.state;

import java.util.Collections;
import java.util.List;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public class OrderProcessing extends AbstractOrderState {

    @Override
    public List<OrderState> nextStates() {
        return Collections.singletonList(new OrderWaitStop());
    }

    @Override
    public List<OrderState> timeoutStates() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().getName().equals(obj.getClass().getName());
    }
}
