import java.util.Collections;
import java.util.List;

public class Statement {
    List<Transaction> transactions;
    private String statementHeader = "date || credit || debit || balance";
    private String output = "";

    Statement(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String print() {
        Collections.reverse(transactions);
        transactions.forEach(transaction -> {
            if (transaction.getTransactionType() == "deposit") {
                output += "\n" + transaction.getDate() + " || " + transaction.getAmount() + " || - || " + transaction.getBalance();
            } else {
                output += "\n" + transaction.getDate() + " || - || " + transaction.getAmount() + " || " + transaction.getBalance();
            }
        });
        return statementHeader + output;
    }
}
