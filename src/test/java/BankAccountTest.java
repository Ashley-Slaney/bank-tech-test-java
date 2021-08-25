import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    private BankAccount subject;

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
}
