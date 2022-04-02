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
        return saveMoney.minus(bettingMoney);
    }

    public Money plusBettingMoney() {
        return saveMoney.plus(bettingMoney);
    }

    public Money plusBettingMoney(double multiple) {
        return saveMoney.plus(bettingMoney.multiple(multiple));
    }
}