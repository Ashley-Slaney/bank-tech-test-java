import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private String amount;
    private String balance;
    private String transactionType;

    private static LocalDate localDate = LocalDate.now();
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    Transaction(float amount, float balance, String transactionType) {
        this.date = dtf.format(localDate);
        this.amount = String.format("%.2f", amount);
        this.balance = String.format("%.2f", balance);
        this.transactionType = transactionType;
    }

    String getDate() {
        return this.date;
    }

    String getAmount() {
        return this.amount;
    }

    String getBalance() {
        return this.balance;
    }

    String getTransactionType() {
        return this.transactionType;
    }
}
