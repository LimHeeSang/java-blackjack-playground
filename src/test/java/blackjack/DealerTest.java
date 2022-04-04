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

    @Test
    void is_under_that_number() {
        Player player = new Player();
        player.receiveCard(new Card("Spade", 10));
        player.receiveCard(new Card("Diamond", 10));

        Assertions.assertThat(player.isUnderThanNumber(20)).isEqualTo(false);
        Assertions.assertThat(player.isUnderThanNumber(21)).isEqualTo(true);
    }
}