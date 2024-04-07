public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread depositorThread = new Thread(new Depositor(account));
        Thread withdrawerThread = new Thread(new Withdrawer(account));

        depositorThread.start();
        withdrawerThread.start();
    }
}
