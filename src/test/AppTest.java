import controller.Controller;
import javafx.stage.Stage;
import model.Player;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest extends ApplicationTest {
    private final Player player = new Player();

    public AppTest() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void testPlay() {
        this.clickOn("Start");
        FxAssert.verifyThat("Init Config Screen", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameLabels() {
        this.clickOn("Start");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        FxAssert.verifyThat("Funds: 300", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Monument Health: 125", NodeMatchers.isNotNull());
    }

    @org.junit.jupiter.api.Test
    void testName() {
        player.setName("Tony");
        assertEquals("Tony", player.getName());
    }
}
