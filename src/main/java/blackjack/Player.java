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

    public boolean hasThatCard(Card card) {
        return cards.existThatCard(card);
    }

    public Money minusBettingMoney() {
        return saveMoney.minus(bettingMoney);
    }
}