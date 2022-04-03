package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RefereeTest {
    private final Referee referee = new Referee();
    private final Player player = new Player(10000);
    private final Dealer dealer = new Dealer();

    @Test
    void get_random_card() {
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
        referee.giveOneCardToPlayer(player);
        Assertions.assertThat(player.getCardCount()).isEqualTo(1);
    }

    @Test
    void give_two_cards_to_player() {
        referee.giveTwoCardsToPlayer(player);
        Assertions.assertThat(player.getCardCount()).isEqualTo(2);
    }

    @Test
    void give_bettingmoney_player_to_dealer() {
        referee.giveMoneyPlayerToDealer(player, dealer);
        Assertions.assertThat(player.getSaveMoney()).isEqualTo(new Money(-10000));
        Assertions.assertThat(dealer.getSaveMoney()).isEqualTo(new Money(10000));
    }
}