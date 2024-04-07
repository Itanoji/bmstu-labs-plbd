public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение на " + amount + ". Текущий баланс: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снятие " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Недостаточно денег на счете для снятия " + amount + ". Текущий баланс: " + balance);
        }
    }
}
