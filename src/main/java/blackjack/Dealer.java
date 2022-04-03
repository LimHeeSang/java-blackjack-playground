package blackjack;

public class Dealer extends AbstractPlayer {

    public Dealer() {
        super(new Money(0));
    }

    public Money minusByBettingMoney(Money bettingMoney) {
        saveMoney = saveMoney.minus(bettingMoney);
        return getSaveMoney();
    }

    public Money plusByBettingMoney(Money bettingMoney) {
        saveMoney = saveMoney.plus(bettingMoney);
        return getSaveMoney();
    }
}
