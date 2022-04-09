package blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameControllerTest {
    @Test
    void play_game() {
        List<Player> players = Arrays.asList(new Player("pobi", 10000), new Player("heesang", 20000));
        Dealer dealer = new Dealer();

        GameController gameController = new GameController(dealer, players);

        gameController.playGame();
    }
}
