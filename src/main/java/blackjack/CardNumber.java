package blackjack;

import java.util.Arrays;

public enum CardNumber {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10), ACE_1(1), ACE_11(11);

    public static final String ERROR_OF_CARD_NUM_RANGE = "숫자는 1~11사이의 수만 가능합니다.";
    private int number;

    CardNumber(int number) {
        this.number = number;
    }

    public static CardNumber getNumber(int number) {
        return Arrays.stream(values())
                .filter(n -> n.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_OF_CARD_NUM_RANGE));
    }

    public static CardNumber getNumberOfSpecial(String special) {
        return Arrays.stream(values())
                .filter(n -> n.name().equals(special))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_OF_CARD_NUM_RANGE));
    }

    int getNumber() {
        return number;
    }
}