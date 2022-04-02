package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    void create_card() {
        Card card1 = new Card("Spade", 2);
        Card card2 = new Card("Heart", 7);

        Assertions.assertThat(card1).isEqualTo(new Card("Spade", 2));
        Assertions.assertThat(card2).isEqualTo(new Card("Heart", 7));
        Assertions.assertThat(card2).isNotEqualTo(card1);
    }

    @Test
    void create_special_card() {
        Card card = new Card("Spade", "JACK");
        Assertions.assertThat(card).isEqualTo(new Card("Spade", "JACK"));
    }
}
