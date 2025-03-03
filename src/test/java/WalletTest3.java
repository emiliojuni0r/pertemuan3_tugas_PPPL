import org.example.Wallet;
import org.junit.jupiter.api.*;

public class WalletTest3 {
    private static Wallet w;

    @BeforeAll
    static void setup() {
        w = new Wallet("", new String[]{}, 0, 0);
    }

    @BeforeEach
    void setupMethod() {
        w.setWalletOwner("owner");
        w.addCard("mandiri");
        w.addMoney(1000, 500);
    }

    @Test
    void testAddMoney(){
        w.addMoney(1000, 500);
        Assertions.assertEquals(2000, w.getCash(), "jumlah cash 2.000");
        Assertions.assertEquals(1000, w.getCoin(), "jumlah coin 1.000");
    }

    @Test
    void testWithdrawMoney(){
        w.withdrawMoney(1000,500);
        Assertions.assertEquals(0, w.getCash(), "jumlah cash 1.000");
        Assertions.assertEquals(0, w.getCoin(), "jumlah coin 500");
    }

    @Test
    void testAddCard(){
        w.addCard("iridnam");
        Assertions.assertTrue(w.getListOfCards().contains("iridnam"), "card iridnam ada");
    }

    @Test
    void testWithdrawCard(){
        w.withdrawCard("mandiri");
        Assertions.assertFalse(w.getListOfCards().contains("mandiri"), "card mandiri tidak ada");
    }

    @Test
    void testShowTotalMoney(){
        Assertions.assertEquals(1500, w.showTotalMoney());
    }
    @Test
    void testSetOwner(){
        w.setWalletOwner("cihuy");
        Assertions.assertEquals("cihuy", w.getOwner());
    }

    @AfterEach
    void cleanupMethod() {
        w.setWalletOwner("");
        w.withdrawCard("mandiri");
        w.setCoin(0);
        w.setCash(0);
    }

    @AfterAll
    static void cleanup() {
        w = null;
    }
}
