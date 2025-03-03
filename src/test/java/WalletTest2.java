import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WalletTest2 {
    @Test
    void testInitialWalletState() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        Assertions.assertEquals("", wallet.getOwner());
        Assertions.assertEquals(100000, wallet.getCash());
        Assertions.assertEquals(500, wallet.getCoin());
    }

    @Test
    void testAddMoney() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        wallet.addMoney(1000, 500);
        Assertions.assertEquals(101000, wallet.getCash(), "jumlah cash 101.000");
        Assertions.assertEquals(1000, wallet.getCoin(), "jumlah coin 1.000");
    }

    @Test
    void testWithdrawMoney() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        wallet.withdrawMoney(1000, 500);
        Assertions.assertEquals(99000, wallet.getCash());
        Assertions.assertEquals(0, wallet.getCoin());
    }

    @Test
    void testAddCard() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        wallet.addCard("mandiri");
        Assertions.assertEquals(new ArrayList<>(Arrays.asList("mandiri")), wallet.getListOfCards());
    }

    @Test
    void testWithdrawCard() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        wallet.addCard("mandiri");
        wallet.withdrawCard("mandiri");
        Assertions.assertEquals(new ArrayList<>(), wallet.getListOfCards());
    }

    @Test
    void testShowTotalMoney() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        Assertions.assertEquals(100500, wallet.showTotalMoney());
    }

    @Test
    void testShowTotalMoneyNotNull() {
        Wallet wallet = new Wallet("", new String[]{}, 100000, 500);
        Assertions.assertNotNull(wallet.showTotalMoney());
    }
}
