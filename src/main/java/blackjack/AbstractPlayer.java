package blackjack;

import java.util.List;

public abstract class AbstractPlayer {
    public static final String INFO_CARD_SYMBOL = "카드 : ";
    public static final String INFO_RESULT_SYMBOL = " - 결과: ";
    public static final String INFO_DELIMITER_SYMBOL = ", ";
    protected final Cards cards;
    protected Money saveMoney;
    protected String name;

    public AbstractPlayer(String name, Money saveMoney) {
        cards = new Cards();
        this.name = name;
        this.saveMoney = saveMoney;
    }

    public void receiveCard(Card... receiveCards) {
        for (Card card : receiveCards) {
            cards.add(card);
        }
    }

    public boolean hasThatCard(Card card) {
        return cards.existThatCard(card);
    }

    public boolean isBlackJack() {
        return cards.isBlackJack();
    }

    public boolean isOverThanNumber(int number) {
        return cards.isOverThanNumber(number);
    }

    public int getCardsSum() {
        return cards.getSum();
    }

    public int getCardCount() {
        return cards.getCardCount();
    }

    public Money getSaveMoney() {
        return saveMoney;
    }

    public boolean isUnderThanNumber(int number) {
        return cards.isUnderThanNumber(number);
    }

    public String getCardsAndSumInfo() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getCardsInfo())
                .append(INFO_RESULT_SYMBOL)
                .append(getCardsSum())
                .toString();
    }

    private String mapCardNamesToString(List<String> cardNames) {
        StringBuilder sb = new StringBuilder();
        for (String cardName : cardNames) {
            sb.append(cardName).append(INFO_DELIMITER_SYMBOL);
        }
        return sb.substring(0, sb.length() - 2);
    }

    public String getName() {
        return name;
    }

    public String getSaveMoneyInfo() {
        return getName() + ": " + saveMoney.getSaveMoneyInfo();
    }

    public String getCardsInfo() {
        List<String> cardNames = cards.getCardNames();

        StringBuilder sb = new StringBuilder();
        return sb.append(getName())
                .append(INFO_CARD_SYMBOL)
                .append(mapCardNamesToString(cardNames))
                .toString();
    }

    public boolean isOverCardsSum(AbstractPlayer player) {
        return getCardsSum() > player.getCardsSum();
    }
}