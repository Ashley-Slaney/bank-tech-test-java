public class BankAccount {
    private float balance = 0;

    public float balance() {
        return this.balance;
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            throw new ArithmeticException("Must be a positive amount to deposit.");
        }

        this.balance += amount;
    }

    public void withdraw(float amount) {
        if (balance - amount < 0) {
            throw new ArithmeticException("Your balance cannot go below zero.");
        }

        this.balance -= amount;
    }
}
