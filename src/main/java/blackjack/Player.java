package blackjack;

public class Player extends AbstractPlayer{
    private final Money bettingMoney;

    public Player(int bettingMoney) {
        super(new Money(0));
        this.bettingMoney = new Money(bettingMoney);
    }

    public Player() {
        this(0);
    }

    public Money minusBettingMoney() {
        saveMoney = saveMoney.minus(bettingMoney);
        return getSaveMoney();
    }

    public Money plusBettingMoney() {
        saveMoney = saveMoney.plus(bettingMoney);
        return getSaveMoney();
    }

    public Money plusBettingMoney(double multiple) {
        saveMoney = saveMoney.plus(bettingMoney.multiple(multiple));
        return getSaveMoney();
    }

    public Money getBettingMoney() {
        return bettingMoney;
    }
}