package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    void minus_by_betting_money() {
        Dealer dealer = new Dealer();
        Money bettingMoney = new Money(10000);

        Assertions.assertThat(dealer.minusByBettingMoney(bettingMoney)).isEqualTo(new Money(-10000));
    }

    @Test
    void plus_by_betting_money() {
        Dealer dealer = new Dealer();
        Money bettingMoney = new Money(10000);

        Assertions.assertThat(dealer.plusByBettingMoney(bettingMoney)).isEqualTo(new Money(10000));
    }
}