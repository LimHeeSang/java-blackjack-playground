package blackjack;

import java.util.Arrays;

public enum CardShape {
    SPADE("Spade", "스페이드"), DIAMOND("Diamond", "다이아몬드"), CLOVER("Clover", "클로버"), HEART("Heart", "하트");

    public static final String ERROR_OF_CARD_SHAPE = "해당 모양을 찾을 수 없습니다.";
    private String shape;
    private String korean;

    CardShape(String shape) {
        this.shape = shape;
    }

    CardShape(String shape, String korean) {
        this.shape = shape;
        this.korean = korean;
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

    public String getKoreanName() {
        return korean;
    }
}
