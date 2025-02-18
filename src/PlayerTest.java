import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Player 1");
    }

    @Test
    void testPlayerMove() {
        player.move(5); // Player moves 5 spaces
        assertEquals(5, player.getPosition(), "Player should be at position 5");
    }

    @Test
    void testPlayerWin() {
        player.setPosition(100); // Player reaches 100
        assertTrue(player.hasWon(), "Player should have finis");
    }

    @Test
    void testPlayerNotWin() {
        player.setPosition(50); // Player is at 50
        assertFalse(player.hasWon(), "Player should not have won yet");
    }
}
