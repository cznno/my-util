package order.state;

/**
 * Created by cznno
 * Date: 18-6-11
 */
public class OrderContext {

    private OrderState state;

    public OrderContext(OrderState state) {
        this.state = state;
    }

    public void next(OrderState state) {
        if (this.state.nextStates() != null && this.state.nextStates().contains(state)) {
            nextLog(state);
        } else {
            throwErrorState(state);
        }
    }

    public void timeout(OrderState state) {
        if (this.state.timeoutStates() != null && this.state.timeoutStates().contains(state)) {
            nextLog(state);
        } else {
            throwErrorState(state);
        }
    }

    public OrderState getState() {
        return state;
    }

    private void nextLog(OrderState state) {
        System.out.println("状态由 " + this.state.getClass().getSimpleName() +
                " 转变为 " + state.getClass().getSimpleName());
        this.state = state;
    }

    private void throwErrorState(OrderState state) {
        throw new RuntimeException("错误的订单状态: 由" + this.state.getClass().getName() + "转变为" + state.getClass().getName());
    }
}
