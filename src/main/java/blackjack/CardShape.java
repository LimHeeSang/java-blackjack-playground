package blackjack;

import java.util.Arrays;

public enum CardShape {
    SPADE("Spade"), DIAMOND("Diamond"), CLOVER("Clover"), HEART("Heart");

    public static final String ERROR_OF_CARD_SHAPE = "해당 모양을 찾을 수 없습니다.";
    private String shape;

    CardShape(String shape) {
        this.shape = shape;
    }

    public static CardShape getShape(String name) {
        return Arrays.stream(values())
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_OF_CARD_SHAPE));
    }

    private String getName() {
        return shape;
    }
}
