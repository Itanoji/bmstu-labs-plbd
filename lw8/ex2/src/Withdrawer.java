import java.util.Random;

public class Withdrawer implements Runnable {
    private final BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(5000)); // Случайная задержка до 5 секунд
                int amount = random.nextInt(10000); // Случайная сумма до 1000
                account.withdraw(amount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
