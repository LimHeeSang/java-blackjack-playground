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
    void minus_betting_money() {
        Player player = new Player(10000);
        Assertions.assertThat(player.minusBettingMoney()).isEqualTo(player.getSaveMoney());
    }

    @Test
    void plus_betting_money() {
        Player player = new Player(10000);
        Assertions.assertThat(player.plusBettingMoney()).isEqualTo(player.getSaveMoney());
    }

    @Test
    void plus_betting_money_multiple() {
        Player player = new Player(10000);
        Assertions.assertThat(player.plusBettingMoney(1.5D)).isEqualTo(player.getSaveMoney());
    }

    @Test
    void is_blackjack() {
        Player player = new Player();
        Card card1 = new Card("Spade", 10);
        Card card2 = new Card("Heart", "ACE_11");
        player.receiveCard(card1, card2);

        Assertions.assertThat(player.isBlackJack()).isEqualTo(true);
    }

    @Test
    void card_sum() {
        Player player = new Player();
        player.receiveCard(new Card("Spade", 5));
        player.receiveCard(new Card("Diamond", 6));
        player.receiveCard(new Card("Heart", 7));

        Assertions.assertThat(player.getCardsSum()).isEqualTo(18);
    }

    @Test
    void over_sum_of_cards() {
        Player player = new Player();
        player.receiveCard(new Card("Spade", 10));
        player.receiveCard(new Card("Diamond", 10));

        Assertions.assertThat(player.isOverThaTNumber(19)).isEqualTo(true);
    }
}
