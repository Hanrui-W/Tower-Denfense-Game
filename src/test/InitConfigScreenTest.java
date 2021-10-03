import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import view.InitConfigScreen;

public class InitConfigScreenTest {

    private final InitConfigScreen testInitConfigScreen = new InitConfigScreen(35, 55);

    @Test
    public void testGetName() {
        testInitConfigScreen.getUsername().setText("Working");
        assertEquals("Working", testInitConfigScreen.getUsername().getText());
    }

}
