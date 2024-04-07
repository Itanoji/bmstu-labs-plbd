import java.util.Random;

public class Consumer implements Runnable {
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(5000)); // Случайная задержка до 5 секунд
                if (store.hasProducts()) {
                    store.buyProduct();
                } else {
                    System.out.println("В магазине нет товара!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
