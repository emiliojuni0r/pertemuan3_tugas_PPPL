import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WalletTest {
    @Test
    void WalletTest2(){
        Wallet wallet = new Wallet("", new String[] {}, 100000, 500);

        Assertions.assertAll(
                () -> Assertions.assertEquals("", wallet.getOwner()),
                () -> Assertions.assertEquals(100000, wallet.getCash()),
                () -> Assertions.assertEquals(500, wallet.getCoin()),
                () -> {
                    wallet.addMoney(1000, 500);
                    Assertions.assertEquals(101000,wallet.getCash(), "jumlah cash 101.000");
                    Assertions.assertEquals(1000,wallet.getCoin(), "jumlah coin 1.000");
                },
                () -> {
                    wallet.withdrawMoney(1000,500);
                    Assertions.assertEquals(100000,wallet.getCash());
                    Assertions.assertEquals(500, wallet.getCoin());
                },
                () -> {
                    wallet.addCard("mandiri");
                    Assertions.assertEquals(new ArrayList<>(Arrays.asList("mandiri")), wallet.getListOfCards());
                },
                () -> {
                    wallet.withdrawCard("mandiri");
                    Assertions.assertEquals(new ArrayList<>(), wallet.getListOfCards());
                },
                () -> Assertions.assertEquals(100500,wallet.showTotalMoney()),
                () -> Assertions.assertNotNull(wallet.showTotalMoney())
        );
    }
}

// sebaiknya satu function untuk tiap cases
