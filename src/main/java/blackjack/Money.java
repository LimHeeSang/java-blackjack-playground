package blackjack;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Money minus(Money compareMoney) {
        return new Money(money - compareMoney.money);
    }

    public Money plus(Money compareMoney) {
        return new Money(money + compareMoney.money);
    }

    public Money multiple(double multiple) {
        return new Money((int) (money * multiple));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
