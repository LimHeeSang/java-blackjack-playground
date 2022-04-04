package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private final Player player = new Player();
    private final Player bettingPlayer = new Player("pobi", 10000);

    @Test
    void receive_card() {
        Card card = new Card("Spade", 4);
        player.receiveCard(card);
        Assertions.assertThat(player.hasThatCard(card)).isEqualTo(true);
    }

    @Test
    void minus_betting_money() {
        Assertions.assertThat(bettingPlayer.minusBettingMoney()).isEqualTo(bettingPlayer.getSaveMoney());
    }

    @Test
    void plus_betting_money() {
        Assertions.assertThat(bettingPlayer.plusBettingMoney()).isEqualTo(bettingPlayer.getSaveMoney());
    }

    @Test
    void plus_betting_money_multiple() {
        Assertions.assertThat(bettingPlayer.plusBettingMoney(1.5D)).isEqualTo(bettingPlayer.getSaveMoney());
    }

    @Test
    void is_blackjack() {
        Card card1 = new Card("Spade", 10);
        Card card2 = new Card("Heart", "ACE_11");
        player.receiveCard(card1, card2);

        Assertions.assertThat(player.isBlackJack()).isEqualTo(true);
    }

    @Test
    void card_sum() {
        player.receiveCard(new Card("Spade", 5));
        player.receiveCard(new Card("Diamond", 6));
        player.receiveCard(new Card("Heart", 7));

        Assertions.assertThat(player.getCardsSum()).isEqualTo(18);
    }

    @Test
    void over_sum_of_cards() {
        player.receiveCard(new Card("Spade", 10));
        player.receiveCard(new Card("Diamond", 10));

        Assertions.assertThat(player.isOverThanNumber(19)).isEqualTo(true);
    }

    @Test
    void get_cards_and_sum_info() {
        bettingPlayer.receiveCard(new Card("Spade", 5));
        bettingPlayer.receiveCard(new Card("Diamond", 6));
        bettingPlayer.receiveCard(new Card("Heart", 7));

        Assertions.assertThat(bettingPlayer.getCardsAndSumInfo()).isEqualTo("pobi카드 : 5스페이드, 6다이아몬드, 7하트 - 결과: 18");
    }

    @Test
    void get_save_money_info() {
        Assertions.assertThat(bettingPlayer.getSaveMoneyInfo()).isEqualTo("pobi: 0");
    }

    @Test
    void get_cards_info() {
        bettingPlayer.receiveCard(new Card("Spade", 5));
        bettingPlayer.receiveCard(new Card("Diamond", 6));
        bettingPlayer.receiveCard(new Card("Heart", 7));

        Assertions.assertThat(bettingPlayer.getCardsInfo()).isEqualTo("pobi카드 : 5스페이드, 6다이아몬드, 7하트");
    }
}