package blackjack;

import java.util.Objects;

public class Card {
    private final CardShape cardShape;
    private final CardNumber cardNumber;

    public Card(String shape, int number) {
        this.cardShape = CardShape.getShape(shape);
        this.cardNumber = CardNumber.getNumber(number);
    }

    public Card(String shape, String special) {
        this.cardShape = CardShape.getShape(shape);
        this.cardNumber = CardNumber.getNumberOfSpecial(special);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardShape == card.cardShape && cardNumber == card.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardShape, cardNumber);
    }
}
