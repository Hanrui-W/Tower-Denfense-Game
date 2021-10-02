
/**import controller.Controller;
=======
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import controller.Controller;
>>>>>>> 62b8148dac91c4182a2511d5497672e99d62de01
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.testng.annotations.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

public class AppTest extends ApplicationTest {
    public AppTest() {
    }

    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void testPlay() {
        this.clickOn("Start");
        FxAssert.verifyThat("Init Config Screen", NodeMatchers.isNotNull());
    }
}*/
