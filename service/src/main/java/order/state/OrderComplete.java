package order.state;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public class OrderComplete extends AbstractOrderState {

    @Override
    public List<OrderState> nextStates() {
        return null;
    }

    @Override
    public List<OrderState> timeoutStates() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
