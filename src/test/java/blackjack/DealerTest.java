package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    void minus_() {
        Dealer dealer = new Dealer();
        Money bettingMoney = new Money(10000);

        Assertions.assertThat(dealer.minusByBettingMoney(bettingMoney)).isEqualTo(new Money(-10000));
    }
}