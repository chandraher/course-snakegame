import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        // simulasi menambahkan snake dan leader
        board.addSnake(16, 6); // ular dari 16 ke 6
        board.addLadder(2, 15); // tangga dari 2 ke 15
    }

    @Test
    void testCheckPositionIfSnake() {
        int newPos = board.checkPosition(16); // Pemain berada di posisi 16 dan akan tergigit ular
        assertEquals(6, newPos, "success");
    }

    @Test
    void testCheckPositionIfLadder() {
        int newPos = board.checkPosition(2); // Pemain berada di posisi 2 dan akan memanjat tangga
        assertEquals(15, newPos, "success");
    }

    @Test
    void testCheckPosition() {
        int newPos = board.checkPosition(10); // Pemain berada di posisi normal
        assertEquals(10, newPos, "success");
    }
}
