import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class TransactionTest {
    LocalDate date = LocalDate.now();

    @Test
    void TestCanCreateATransaction() {
        Transaction subject = new Transaction(500, 500, "deposit");
        assertEquals(date, subject.getDate());
        assertEquals(500, subject.getAmount());
        assertEquals(500, subject.getBalance());
        assertEquals("deposit", subject.getTransactionType());
    }
}
