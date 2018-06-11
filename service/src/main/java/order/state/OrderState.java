package order.state;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public interface OrderState {

    List<OrderState> nextStates();

    List<OrderState> timeoutStates();

    boolean isFinished();
}
