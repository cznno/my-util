package order;

import order.state.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by cznno
 * Date: 18-6-11
 */
class OrderTest {

    private OrderContext start() {
        return new OrderContext(new OrderWaitStart());
    }

    @Test
    void orderFlowTest() {
        final OrderContext context = start();
        context.next(new OrderProcessing());
        context.next(new OrderWaitStop());
        context.next(new OrderComplete());
//        context.timeout(new OrderStartTimeout());
        assertTrue(context.getState().isFinished());
    }

    @Test
    void orderFlowTest2() {
        final OrderContext context = start();
        context.next(new OrderProcessing());
        context.next(new OrderWaitStop());
        context.next(new OrderComplete());
        assertThrows(RuntimeException.class, () -> context.timeout(new OrderStartTimeout()));
    }
}
