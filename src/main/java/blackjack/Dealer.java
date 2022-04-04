package blackjack;

public class Dealer extends AbstractPlayer {

    public Dealer() {
        super(Player.DEFAULT_NAME, new Money(0));
    }

    public Money minusByBettingMoney(Money bettingMoney) {
        saveMoney = saveMoney.minus(bettingMoney);
        return getSaveMoney();
    }

    public Money plusByBettingMoney(Money bettingMoney) {
        saveMoney = saveMoney.plus(bettingMoney);
        return getSaveMoney();
    }

    public Money minusByBettingMoney(Money bettingMoney, double multiple) {
        saveMoney = saveMoney.minus(bettingMoney.multiple(multiple));
        return getSaveMoney();
    }
}
