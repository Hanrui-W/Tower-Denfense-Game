
import controller.Controller;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class AppTest extends ApplicationTest {
    public AppTest() {
    }

    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void testWelcomeScreen() {
        clickOn("Start");
        verifyThat("#Init Config Screen", NodeMatchers.isNotNull());
    }
}
