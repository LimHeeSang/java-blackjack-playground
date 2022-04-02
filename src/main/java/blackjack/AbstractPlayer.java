package blackjack;

public abstract class AbstractPlayer {
    protected final Cards cards = new Cards();
    protected final Money saveMoney;

    public AbstractPlayer(Money saveMoney) {
        this.saveMoney = saveMoney;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveTwoCards(Card card1, Card card2) {
        receiveCard(card1);
        receiveCard(card2);
    }

    public boolean hasThatCard(Card card) {
        return cards.existThatCard(card);
    }
}
