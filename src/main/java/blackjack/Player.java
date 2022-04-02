package blackjack;

public class Player {
    private final Cards cards = new Cards();

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public boolean hasThatCard(Card card) {
        return cards.existThatCard(card);
    }
}