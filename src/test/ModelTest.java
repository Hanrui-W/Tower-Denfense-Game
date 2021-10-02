import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Player;

import org.junit.jupiter.api.Test;

class ModelTest {

    private final Player player = new Player();

    @Test
    void testName() {
        player.setName("Tony");
        assertEquals("Tony", player.getName());
    }

}