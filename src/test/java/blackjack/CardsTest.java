package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CardsTest {
    @Test
    void card_sum() {
        List<Card> cardList = Arrays.asList(
                new Card("Spade", 5),
                new Card("Heart", 4),
                new Card("Diamond", 10));
        Cards cards = new Cards(cardList);

        Assertions.assertThat(cards.getSum()).isEqualTo(19);
    }

    @Test
    void over_sum_of_cards() {
        Player player = new Player();
        player.receiveCard(new Card("Spade", 10));
        player.receiveCard(new Card("Diamond", 10));

        Assertions.assertThat(player.isOverThaTNumber(19)).isEqualTo(true);
    }
}