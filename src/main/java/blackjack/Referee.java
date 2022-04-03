package blackjack;

import java.util.*;

public class Referee {
    public static final int COUNT_OF_CARD_SHAPE = 4;
    public static final int COUNT_OF_CARD_NUMBER = 13;
    private final Cards cardDeck;
    private final List<Integer> indexRandomNumbers;

    public Referee() {
        this.cardDeck = createCardDeck();
        this.indexRandomNumbers = createIndexRandomNumber();
    }

    public Referee(Cards cards) {
        this.cardDeck = cards;
        this.indexRandomNumbers = createIndexRandomNumber();
    }

    private List<Integer> createIndexRandomNumber() {
        List<Integer> randomNumbers = new LinkedList<>();
        for (int i = 0; i < cardDeck.getCardCount(); i++) {
            randomNumbers.add(i);
        }
        return randomNumbers;
    }

    private Cards createCardDeck() {
        CardShape[] shapes = CardShape.values();

        List<Card> cards = new ArrayList<>();
        for (int idx = 0; idx < COUNT_OF_CARD_SHAPE; idx++) {
            createCard(cards, shapes[idx]);
        }
        return new Cards(cards);
    }

    private void createCard(List<Card> cards, CardShape shape) {
        CardNumber[] numbers = CardNumber.values();

        for (int idx = 0; idx < COUNT_OF_CARD_NUMBER; idx++) {
            cards.add(new Card(shape, numbers[idx]));
        }
    }

    public Card getRandomCard() {
        int criterion = indexRandomNumbers.size();

        Random random = new Random();
        int pickRandomIndex = random.nextInt(criterion);
        int cardIndex = indexRandomNumbers.remove(pickRandomIndex);

        return cardDeck.getCardOfIndex(cardIndex);
    }

    public void giveOneCardToPlayer(Player... players) {
        for (Player player : players) {
            player.receiveCard(getRandomCard());
        }
    }

    public void giveTwoCardsToPlayer(Player... players) {
        for (Player player : players) {
            player.receiveCard(getRandomCard(), getRandomCard());
        }
    }

    public void giveMoneyPlayerToDealer(Player player, Dealer dealer) {
        player.minusBettingMoney();
        dealer.plusByBettingMoney(player.getBettingMoney());
    }
}