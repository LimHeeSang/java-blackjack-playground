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
}