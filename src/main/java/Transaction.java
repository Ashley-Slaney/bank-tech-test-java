import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private float amount;
    private float balance;
    private String transactionType;

    Transaction(float amount, float balance, String transactionType) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
        this.transactionType = transactionType;
    }

    LocalDate getDate() {
        return this.date;
    }

    float getAmount() {
        return this.amount;
    }

    float getBalance() {
        return this.balance;
    }

    String getTransactionType() {
        return this.transactionType;
    }
}
