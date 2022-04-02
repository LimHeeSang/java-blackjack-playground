package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {
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
}
