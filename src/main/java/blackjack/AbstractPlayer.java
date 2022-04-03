package blackjack;

public abstract class AbstractPlayer {
    protected final Cards cards;
    protected final Money saveMoney;

    public AbstractPlayer(Money saveMoney) {
        cards = new Cards();
        this.saveMoney = saveMoney;
    }

    public void receiveCard(Card... receiveCards) {
        for (Card card : receiveCards) {
            cards.add(card);
        }
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

    public int getCardCount() {
        return cards.getCardCount();
    }
}