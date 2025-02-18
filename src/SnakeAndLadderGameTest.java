import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnakeAndLadderGameTest {

    private Board board;
    private List<Player> players;
    private Dice dice;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.addSnake(16, 6);
        board.addLadder(2, 15);

        players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));

        dice = new Dice();
    }

    @Test
    void testGamePlay() {
        // Simulasi permainan
        SnakeAndLadderGame.playGame(players, dice, board);
        // Setelah simulasi, pastikan ada pemain yang menang
        boolean player1Won = players.get(0).hasWon();
        boolean player2Won = players.get(1).hasWon();
        assertTrue(player1Won || player2Won, "one playe have a finish");
    }
}
