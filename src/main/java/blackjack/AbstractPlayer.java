package blackjack;

public abstract class AbstractPlayer {
    protected final Cards cards;
    protected final Money saveMoney;

    public AbstractPlayer(Money saveMoney) {
        cards = new Cards();
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

    public boolean isBlackJack() {
        return cards.isBlackJack();
    }

    public boolean isOverThaTNumber(int number) {
        return cards.isOverThaTNumber(number);
    }

    public int getCardsSum() {
        return cards.getSum();
    }
}