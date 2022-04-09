package blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final Referee referee;
    private final Dealer dealer;
    private final List<Player> players;

    public GameController(Dealer dealer, List<Player> players) {
        referee = new Referee();
        this.dealer = dealer;
        this.players = players;
    }

    public void playGame() {
        referee.giveTwoCardsToPlayer(dealer);
        referee.giveTwoCardsToPlayer(playerListToArray(players));
        printFirstInfo();

        for (Player player : players) {
            if (inputCardStatus()) {
                referee.giveOneCardToPlayer(player);
                System.out.println(player.getCardsInfo());
            }
        }
        checkDealerGiveCards();

        //승자를 판단하고 베팅금액을 지정한는 로직 추가

        System.out.println(dealer.getCardsAndSumInfo());
        for (Player player : players) {
            System.out.println(player.getCardsAndSumInfo());
        }


        System.out.println("## 최종 수익");
        System.out.println(dealer.getSaveMoneyInfo());
        for (Player player : players) {
            System.out.println(player.getSaveMoneyInfo());
        }
    }

    private void checkDealerGiveCards() {
        if (dealer.isUnderThanNumber(16)) {
            referee.giveOneCardToPlayer(dealer);
            System.out.println("딜러는 16이하라 카드를 더 받았습니다.");
            return;
        }
    }

    private boolean inputCardStatus() {
        return true;
    }

    private Player[] playerListToArray(List<Player> players) {
        return players.toArray(new Player[players.size()]);
    }

    private void printFirstInfo() {
        printGiveCardsInfo();

        System.out.println(dealer.getCardsInfo());
        for (Player player : players) {
            System.out.println(player.getCardsInfo());
        }
    }

    private void printGiveCardsInfo() {
        String names = "";
        for (Player player : players) {
            names += player.getName() + ", ";
        }
        System.out.println("딜러와" + names + "에게 2장의 카드를 나누어 주었습니다.");
    }
}
