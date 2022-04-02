package blackjack;

public class Player {
    private final Cards cards = new Cards();
    private final Money bettingMoney;
    private final Money saveMoney;

    public Player(int bettingMoney) {
        this.bettingMoney = new Money(bettingMoney);
        this.saveMoney = new Money(0);
    }

    public Player() {
        this(0);
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

    public Money minusBettingMoney() {
        return saveMoney.minus(bettingMoney);
    }

    public Money plusBettingMoney() {
        return saveMoney.plus(bettingMoney);
    }

    public Money plusBettingMoney(double multiple) {
        return saveMoney.plus(bettingMoney.multiple(multiple));
    }
}