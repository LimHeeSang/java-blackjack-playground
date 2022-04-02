package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void receive_card() {
        Player player = new Player();
        Card card = new Card("Spade", 4);

        player.receiveCard(card);
        Assertions.assertThat(player.hasThatCard(card)).isEqualTo(true);
    }

    @Test
    void receive_two_cards() {
        Player player = new Player();
        Card card1 = new Card("Spade", 4);
        Card card2 = new Card("Spade", 6);

        player.receiveTwoCards(card1, card2);
        Assertions.assertThat(player.hasThatCard(card1)).isEqualTo(true);
        Assertions.assertThat(player.hasThatCard(card2)).isEqualTo(true);
    }

    @Test
    void minus_betting_money() {
        Player player = new Player(10000);
        Assertions.assertThat(player.minusBettingMoney()).isEqualTo(new Money(-10000));
    }

    @Test
    void plus_betting_money() {
        Player player = new Player(10000);
        Assertions.assertThat(player.plusBettingMoney()).isEqualTo(new Money(10000));
    }
}
