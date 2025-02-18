import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void testDiceRoll() {
        Dice dice = new Dice();
        int roll = dice.roll();
        assertTrue(roll >= 1 && roll <= 6, "memastikan dadu yang tergenerate dimulai 1 max 6");
    }
}
