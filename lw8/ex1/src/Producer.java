import java.util.Random;

public class Producer implements Runnable {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(3000)); // Случайная задержка до 3 секунд
                Product product = new Product("Product " + random.nextInt(1000));
                store.addProduct(product);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
