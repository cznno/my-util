package order.state;

import java.util.Collections;
import java.util.List;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public class OrderWaitStop extends AbstractOrderState {
    @Override
    public List<OrderState> nextStates() {
        return Collections.singletonList(new OrderComplete());
    }

    @Override
    public List<OrderState> timeoutStates() {
        return Collections.singletonList(new OrderStopTimeOut());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
