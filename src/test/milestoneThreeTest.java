import controller.Controller;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.api.FxRobot;


public class milestoneThreeTest extends ApplicationTest {

    public milestoneThreeTest() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void testPurchaseTower() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("You purchased flowy\nflower", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPurchaseWithoutPlacing() {
        this.clickOn("Start");
        this.write("Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        this.clickOn("Purchase");
        FxAssert.verifyThat("OK", NodeMatchers.isNotNull());
        this.clickOn("OK");
    }
}
