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
}
