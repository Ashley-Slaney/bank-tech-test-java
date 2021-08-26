import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    private BankAccount subject;

    @BeforeEach
    void setup() {
        subject = new BankAccount();
    }
    LocalDate date = LocalDate.now();

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
}
