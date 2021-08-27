import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private float balance = 0;
    List<Transaction> transactions = new ArrayList<Transaction>();

    public float balance() {
        return this.balance;
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            throw new ArithmeticException("Must be a positive amount to deposit.");
        }

        this.balance += amount;
        storeTransaction(amount, balance, "deposit");
    }

    public void withdraw(float amount) {
        if (balance - amount < 0) {
            throw new ArithmeticException("Your balance cannot go below zero.");
        }

        this.balance -= amount;
        storeTransaction(amount, balance, "withdraw");
    }

    public void storeTransaction(float amount, float balance, String transactionType) {
        Transaction transaction = new Transaction(amount, balance, transactionType);
        transactions.add(transaction);
    }

    public String printStatement() {
        Statement statement = new Statement(transactions);
        return statement.print();
    }
}
