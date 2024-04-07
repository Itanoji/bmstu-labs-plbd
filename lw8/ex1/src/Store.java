import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Store {
    private final BlockingQueue<Product> products = new LinkedBlockingQueue<>();

    public void addProduct(Product product) {
        try {
            products.put(product);
            System.out.println("Производитель поставил в магазин: " + product.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Product buyProduct() {
        Product product = null;
        try {
            product = products.take();
            System.out.println("Покупатель купил: " + product.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return product;
    }

    public boolean hasProducts() {
        return !products.isEmpty();
    }
}
