import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void testBalanceStartsEmpty() {
        BankAccount subject = new BankAccount();
        float result = subject.balance();
        assertEquals(0, result);
    }

    @Test
    void testDepositMoneyIncreasesBalance() {
        BankAccount subject = new BankAccount();
        subject.deposit(500);
        float result = subject.balance();
        assertEquals(500, result);
    }

    @Test
    void testDepositIncorrectAmountReturnsMessage() {
        BankAccount subject = new BankAccount();
        Assertions.assertThrows(ArithmeticException.class, () -> subject.deposit(-500));
    }

    @Test
    void testWithdrawMoneyDecreasesBalance() {
        BankAccount subject = new BankAccount();
        subject.deposit(500);
        subject.withdraw(100);
        float result = subject.balance();
        assertEquals(400, result);
    }

}
