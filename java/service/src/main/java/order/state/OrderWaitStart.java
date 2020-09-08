package order.state;

import java.util.Collections;
import java.util.List;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public class OrderWaitStart extends AbstractOrderState {

    @Override
    public List<OrderState> nextStates() {
        return Collections.singletonList(new OrderProcessing());
    }

    @Override
    public List<OrderState> timeoutStates() {
        return Collections.singletonList(new OrderStartTimeout());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
