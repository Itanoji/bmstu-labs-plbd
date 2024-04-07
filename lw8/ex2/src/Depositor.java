import java.util.Random;

public class Depositor implements Runnable {
    private final BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(3000)); // Случайная задержка до 3 секунд
                int amount = random.nextInt(1000); // Случайная сумма до 1000
                account.deposit(amount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
