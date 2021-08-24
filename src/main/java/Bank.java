public class Bank {
    private int balance;

    public void bank() {
        int balance = 0;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
