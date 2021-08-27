import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    private BankAccount subject;

    LocalDate localDate = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    String date = dtf.format(localDate);

    @BeforeEach
    void setup() {
        subject = new BankAccount();
    }


    @Test
    void testBalanceStartsEmpty() {
        float result = subject.balance();
        assertEquals(0, result);
    }

    @Test
    void testDepositMoneyIncreasesBalance() {
        subject.deposit(500);
        float result = subject.balance();
        assertEquals(500, result);
    }

    @Test
    void testDepositDoesntAllowNegativeAmount() {
        Assertions.assertThrows(ArithmeticException.class, () -> subject.deposit(-500));
    }

    @Test
    void testWithdrawMoneyDecreasesBalance() {
        subject.deposit(500);
        subject.withdraw(100);
        float result = subject.balance();
        assertEquals(400, result);
    }

    @Test
    void testWithdrawCantMakeBalanceGoBelowZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> subject.withdraw(5000));
    }

    @Test
    void testCanStoreATransaction() {
        subject.deposit(500);
        assertEquals(date, subject.transactions.get(0).getDate());
        assertEquals(500, subject.transactions.get(0).getBalance());
        assertEquals(500, subject.transactions.get(0).getAmount());
        assertEquals("deposit", subject.transactions.get(0).getTransactionType());
    }

    @Test
    void testCanStoreMultipleTransactions() {
        subject.deposit(500);
        subject.deposit(500);
        subject.deposit(500);
        subject.withdraw(1000);
        assertEquals(500, subject.transactions.get(3).getBalance());
    }

    @Test
    void testCanPrintAStatement() {
        subject.deposit(1000);
        subject.deposit(2000);
        subject.withdraw(500);
        assertEquals("date || credit || debit || balance\n" + date + " || - || 500.00 || 2500.00\n" + date +" || 2000.00 || - || 3000.00\n" + date + " || 1000.00 || - || 1000.00", subject.printStatement());
    }
}
