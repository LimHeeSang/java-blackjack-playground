package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RefereeTest {
    @Test
    void get_random_card() {
        Referee referee = new Referee();
        Assertions.assertThat(referee.getRandomCard()).isInstanceOf(Card.class);
    }
    
    @Test
    void get_random_card_count() {
        List<Card> cardList = Arrays.asList(
                new Card("Spade", 5),
                new Card("Heart", 4),
                new Card("Diamond", 10));
        Cards cards = new Cards(cardList);

        Referee referee = new Referee(cards);
        Card randomCard1 = referee.getRandomCard();
        Card randomCard2 = referee.getRandomCard();
        Card randomCard3 = referee.getRandomCard();

        Assertions.assertThat(cardList).containsOnly(randomCard1, randomCard2, randomCard3);
    }

    @Test
    void give_one_card_to_player() {
        Referee referee = new Referee();
        Player player = new Player();

        referee.giveOneCardToPlayer(player);
        Assertions.assertThat(player.getCardCount()).isEqualTo(1);
    }

    @Test
    void give_two_cards_to_player() {
        Referee referee = new Referee();
        Player player = new Player();

        referee.giveTwoCardsToPlayer(player);
        Assertions.assertThat(player.getCardCount()).isEqualTo(2);
    }
}