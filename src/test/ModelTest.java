import static org.junit.jupiter.api.Assertions.assertEquals;

import model.GameDifficultyLevel;
import model.Model;

import org.junit.jupiter.api.Test;

class ModelTest {

    private final Model model = new Model();

    @Test
    void testInitGame() {
        model.initGame("abc", GameDifficultyLevel.EASY);

        assertEquals("abc", model.getPlayerName());
        assertEquals(1000, model.getMoney());
        assertEquals(1000, model.getMonumentHealth());
    }

}