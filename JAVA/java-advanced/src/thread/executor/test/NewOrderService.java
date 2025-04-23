package thread.executor.test;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class NewOrderService {

    public void order(String orderNo) throws ExecutionException, InterruptedException {
        // futuer 사용
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        ExecutorService es = Executors.newFixedThreadPool(4);

        Future<Boolean> submit1 = es.submit(inventoryWork);
        Future<Boolean> submit2 = es.submit(shippingWork);
        Future<Boolean> submit3 = es.submit(accountingWork);

        Boolean reslut1 = submit1.get();
        Boolean reslut2 = submit2.get();
        Boolean reslut3= submit3.get();

        if (reslut1 && reslut2 && reslut3) {
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
        } else {
            log("일부 작업이 실패했습니다.");
        }
        es.close();

    }

    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트 : " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean>{

        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림 : " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean>{

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("회계 시스템 업데이트 업데이트 : " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
