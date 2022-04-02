package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    public static final int BLACKJACK_GOAL_NUMBER = 21;
    private final List<Card> cards;

    public Cards(List<Card> cardList) {
        this.cards = cardList;
    }

    public Cards() {
        this(new ArrayList<>());
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean existThatCard(Card card) {
        return cards.contains(card);
    }

    public int getSum() {
        return cards.stream()
                .map(Card::getNumber)
                .reduce(0, Integer::sum);
    }

    public boolean isOverThaTNumber(int number) {
        return getSum() > number;
    }

    public boolean isBlackJack() {
        return getSum() == BLACKJACK_GOAL_NUMBER;
    }
}
