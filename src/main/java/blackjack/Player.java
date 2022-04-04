package blackjack;

public class Player extends AbstractPlayer{
    public static final String DEFAULT_NAME = "no_name";
    private final Money bettingMoney;

    public Player() {
        this(0);
    }

    public Player(int bettingMoney) {
        this(DEFAULT_NAME, bettingMoney);
    }

    public Player(String name, int bettingMoney) {
        super(name, new Money(0));
        this.bettingMoney = new Money(bettingMoney);
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