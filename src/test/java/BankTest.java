import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void testBalanceStartsEmpty() {
        Bank subject = new Bank();
        int result = subject.balance();
        assertEquals(0, result);
    }

    @Test
    void testDepositMoneyIncreasesBalance() {
        Bank subject = new Bank();
        subject.deposit(500);
        int result = subject.balance();
        assertEquals(500, result);
    }
}
