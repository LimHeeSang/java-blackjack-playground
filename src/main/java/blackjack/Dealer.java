package blackjack;

public class Dealer extends AbstractPlayer {

    public Dealer() {
        super(new Money(0));
    }

    public Money minusByBettingMoney(Money bettingMoney) {
        return saveMoney.minus(bettingMoney);
    }

    public Money plusByBettingMoney(Money bettingMoney) {
        return saveMoney.plus(bettingMoney);
    }
}
